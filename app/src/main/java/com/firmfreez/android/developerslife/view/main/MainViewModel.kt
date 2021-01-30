package com.firmfreez.android.developerslife.view.main

import androidx.lifecycle.ViewModel
import com.firmfreez.android.developerslife.di.App
import com.firmfreez.android.developerslife.view.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MainViewModel: ViewModel() {
    @Inject lateinit var router: Router

    init {
        App.instance.component?.inject(this)
    }

    fun showPostsFragment() {
        router.navigateTo(Screens.postsFragment())
    }
}