package com.firmfreez.android.developerslife.view

import com.firmfreez.android.developerslife.view.posts.PostsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun postsFragment() = FragmentScreen{ PostsFragment.newInstance() }
}