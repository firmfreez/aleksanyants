package com.firmfreez.android.developerslife.di.components

import android.content.Context
import com.firmfreez.android.developerslife.di.modules.AppNavigationModule
import com.firmfreez.android.developerslife.di.modules.NetworkModule
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules=[AppNavigationModule::class, NetworkModule::class])
@Singleton
interface AppComponent {
    fun provideContext(): Context
    fun provideCicerone(): Cicerone<Router>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}