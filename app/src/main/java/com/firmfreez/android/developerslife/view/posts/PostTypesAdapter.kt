package com.firmfreez.android.developerslife.view.posts

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.firmfreez.android.developerslife.view.posts.best.BestPostFragment
import com.firmfreez.android.developerslife.view.posts.hottest.HottestPostFragment
import com.firmfreez.android.developerslife.view.posts.latest.LatestPostFragment
import com.firmfreez.android.developerslife.view.posts.random.RandomPostFragment

class PostTypesAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RandomPostFragment.newInstance()
            1 -> LatestPostFragment.newInstance()
            2 -> BestPostFragment.newInstance()
            3 -> HottestPostFragment.newInstance()

            else -> RandomPostFragment.newInstance()
        }
    }
}