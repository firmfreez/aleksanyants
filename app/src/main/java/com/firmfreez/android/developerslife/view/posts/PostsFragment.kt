package com.firmfreez.android.developerslife.view.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.databinding.FragmentPostsBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment

class PostsFragment: BaseFragment() {
    private lateinit var binding: FragmentPostsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        binding.viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        setToolBar("Лол", false, binding.root)
        return binding.root
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