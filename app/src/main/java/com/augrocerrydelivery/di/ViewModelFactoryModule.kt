package com.augrocerrydelivery.di

import androidx.lifecycle.ViewModelProvider
import com.augrocerrydelivery.ui.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}