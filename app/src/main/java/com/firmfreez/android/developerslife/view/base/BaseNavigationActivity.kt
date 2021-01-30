package com.firmfreez.android.developerslife.view.base

import com.firmfreez.android.developerslife.di.App
import com.firmfreez.android.developerslife.navigation.CustomNavigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BaseNavigationActivity: BaseActivity() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator by lazy { CustomNavigator(this, getFragmentContainerId()) }

    init {
        App.instance.component?.inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onStop() {
        super.onStop()
        navigatorHolder.removeNavigator()
    }


}