package com.firmfreez.android.developerslife.view.posts.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.databinding.FragmentLatestPostBinding
import com.firmfreez.android.developerslife.databinding.FragmentRandomPostBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment

class LatestPostFragment: BaseFragment() {
    private lateinit var binding: FragmentLatestPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLatestPostBinding.inflate(inflater, container, false)
        binding.viewModel = ViewModelProvider(this).get(LatestPostViewModel::class.java)
        return binding.root
    }

    companion object {
        fun newInstance(): LatestPostFragment {
            val args = Bundle()

            val fragment = LatestPostFragment()
            fragment.arguments = args
            return fragment
        }
    }
}