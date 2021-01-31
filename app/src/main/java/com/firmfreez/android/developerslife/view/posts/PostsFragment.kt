package com.firmfreez.android.developerslife.view.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.R
import com.firmfreez.android.developerslife.databinding.FragmentPostsBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class PostsFragment: BaseFragment() {
    private lateinit var binding: FragmentPostsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        binding.viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        binding.viewPager.adapter = PostTypesAdapter(this)
        setToolBar(getString(R.string.name), false, binding.root, R.color.white, R.color.black)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = getString(R.string.random)
                1 -> tab.text = getString(R.string.latest)
                2 -> tab.text = getString(R.string.best)
                3 -> tab.text = getString(R.string.hottest)
            }
        }.attach()
    }

    companion object {
        fun newInstance(): PostsFragment {
            val args = Bundle()

            val fragment = PostsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}