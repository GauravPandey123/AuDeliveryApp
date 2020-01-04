package com.augrocerrydelivery.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.augrocerrydelivery.utils.PreferenceKeys
import dagger.Module
import dagger.Provides
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

}