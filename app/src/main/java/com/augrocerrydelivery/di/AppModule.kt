package com.augrocerrydelivery.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract
import com.augrocerrydelivery.utils.AppConstatnts
import com.augrocerrydelivery.utils.LiveDataCallAdapterFactory
import com.augrocerrydelivery.utils.PreferenceKeys
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {


    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(
            PreferenceKeys.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }


    @Singleton
    @Provides
    fun provideSharedPrefsEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }


    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder:  Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(AppConstatnts.BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }



}