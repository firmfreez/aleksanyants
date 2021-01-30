package com.firmfreez.android.developerslife.view.posts.best

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.developerslife.databinding.FragmentBestPostBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment

class BestPostFragment: BaseFragment() {
    private lateinit var binding: FragmentBestPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBestPostBinding.inflate(inflater, container, false)
        binding.viewModel = ViewModelProvider(this).get(BestPostViewModel::class.java)
        return binding.root
    }

    companion object {
        fun newInstance(): BestPostFragment {
            val args = Bundle()

            val fragment = BestPostFragment()
            fragment.arguments = args
            return fragment
        }
    }
}