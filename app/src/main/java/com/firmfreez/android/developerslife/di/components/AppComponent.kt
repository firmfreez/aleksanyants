package com.firmfreez.android.developerslife.di.components

import android.content.Context
import com.firmfreez.android.developerslife.di.modules.AppNavigationModule
import com.firmfreez.android.developerslife.di.modules.NetworkModule
import com.firmfreez.android.developerslife.view.base.BaseActivity
import com.firmfreez.android.developerslife.view.base.BaseFragment
import com.firmfreez.android.developerslife.view.base.BaseNavigationActivity
import com.firmfreez.android.developerslife.view.main.MainActivity
import com.firmfreez.android.developerslife.view.main.MainViewModel
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

//    Activities
    fun inject(baseActivity: BaseActivity)
    fun inject(baseNavigationActivity: BaseNavigationActivity)
    fun inject(baseFragment: BaseFragment)

    fun inject(mainActivity: MainActivity)

//    ViewModels
    fun inject(mainViewModel: MainViewModel)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}