package com.augrocerrydelivery

import android.app.Activity
import android.app.Application
import com.augrocerrydelivery.di.AppInjector
import com.augrocerrydelivery.session.SessionManager
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


//global variables can be accessed across application context
val sessionManager: SessionManager by lazy {
    BaseApplication.sessionManager!!
}

class BaseApplication : Application() , HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        init()
    }

    companion object{
        var sessionManager: SessionManager? = null

    }

    override fun activityInjector() = dispatchingAndroidInjector

    private fun init(){
        sessionManager = SessionManager(applicationContext!!)

    }

}