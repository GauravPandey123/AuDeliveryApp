package com.augrocerrydelivery

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : Application()  {


    override fun onCreate() {
        super.onCreate()


    }


//    override fun activityInjector() = dispatchingAndroidInjector

}