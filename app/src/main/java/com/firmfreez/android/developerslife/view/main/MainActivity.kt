package com.firmfreez.android.developerslife.view.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.di.App
import com.firmfreez.android.developerslife.view.base.BaseNavigationActivity

class MainActivity : BaseNavigationActivity() {
    private lateinit var viewModel: MainViewModel

    init {
        App.instance.component?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        TODO: Сделать нормально
        viewModel.showPostsFragment()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}