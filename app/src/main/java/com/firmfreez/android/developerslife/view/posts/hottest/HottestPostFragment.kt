package com.firmfreez.android.developerslife.view.posts.hottest

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.firmfreez.android.developerslife.databinding.FragmentHottestPostBinding
import com.firmfreez.android.developerslife.view.base.BaseFragment
import kotlinx.android.synthetic.main.post_item.view.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.next.setOnClickListener {
            binding.post.post_loader?.isVisible = true
            binding.viewModel?.loadNextPost()
        }

        binding.previous.setOnClickListener {
            binding.viewModel?.loadPrevPost()
        }

        binding.viewModel?.currentPost?.observe(viewLifecycleOwner) {
//            TODO: Обработать ошибку при null

            it?.gifURL?.let {url ->
                loadImage(url)
            }

            it?.description?.let { description ->
                binding.post.post_text.text = description
            }
        }

        binding.viewModel?.getCurrentIndex()?.observe(viewLifecycleOwner) {
            binding.previous.isEnabled = it > 0
        }
    }

    private fun loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.post.post_loader?.isVisible = false
                    return false
                }
            })
            .into(binding.post.post_image)
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