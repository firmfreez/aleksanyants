package com.firmfreez.android.developerslife.view.posts.hottest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.databinding.FragmentHottestPostBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment

class HottestPostFragment: BaseFragment() {
    private lateinit var binding: FragmentHottestPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHottestPostBinding.inflate(inflater, container, false)
        binding.viewModel = ViewModelProvider(this).get(HottestPostViewModel::class.java)
        return binding.root
    }

    companion object {
        fun newInstance(): HottestPostFragment {
            val args = Bundle()

            val fragment = HottestPostFragment()
            fragment.arguments = args
            return fragment
        }
    }
}