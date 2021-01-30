package com.firmfreez.android.developerslife.view.base

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.firmfreez.android.developerslife.R
import com.firmfreez.android.developerslife.di.App

abstract class BaseActivity: AppCompatActivity() {
    @LayoutRes
    protected open fun getLayoutResId(): Int = R.layout.activity_main

    @IdRes
    protected open fun getFragmentContainerId() = R.id.fragment_container

    init {
        App.instance.component?.inject(this)
    }
}