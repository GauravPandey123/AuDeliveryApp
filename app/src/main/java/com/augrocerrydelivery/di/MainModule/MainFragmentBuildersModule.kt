package com.augrocerrydelivery.di.MainModule

import androidx.transition.Visibility
import com.augrocerrydelivery.ui.fragment.DashBoardFragment
import com.augrocerrydelivery.ui.fragment.NotificationFragment
import com.augrocerrydelivery.ui.fragment.ProfileFragment
import com.augrocerrydelivery.ui.fragment.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun homefragment(): DashBoardFragment

    @ContributesAndroidInjector()
    abstract fun notificationfragment(): NotificationFragment

    @ContributesAndroidInjector()
    abstract fun profileFragment(): ProfileFragment

    @ContributesAndroidInjector()
    abstract fun settingfragment(): SettingFragment

}