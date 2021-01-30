package com.firmfreez.android.developerslife.di

import android.app.Application
import com.firmfreez.android.developerslife.BuildConfig
import com.firmfreez.android.developerslife.di.components.AppComponent
import com.firmfreez.android.developerslife.di.components.DaggerAppComponent
import timber.log.Timber

class App : Application() {
    var component: AppComponent? = null
    get() {
        if (field == null) {
            field = DaggerAppComponent
                .factory()
                .create(this)
        }
        return field
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var instance: App
    }
}