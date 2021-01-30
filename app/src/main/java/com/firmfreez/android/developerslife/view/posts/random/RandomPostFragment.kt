package com.firmfreez.android.developerslife.view.posts.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.databinding.FragmentRandomPostBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment

class RandomPostFragment: BaseFragment() {
    private lateinit var binding: FragmentRandomPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomPostBinding.inflate(inflater, container, false)
        binding.viewModel = ViewModelProvider(this).get(RandomPostViewModel::class.java)
        return binding.root
    }

    companion object {
        fun newInstance(): RandomPostFragment {
            val args = Bundle()

            val fragment = RandomPostFragment()
            fragment.arguments = args
            return fragment
        }
    }
}