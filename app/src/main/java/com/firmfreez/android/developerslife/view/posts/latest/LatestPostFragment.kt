package com.firmfreez.android.developerslife.view.posts.latest

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
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.firmfreez.android.developerslife.databinding.FragmentLatestPostBinding
import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.view.base.BaseFragment
import kotlinx.android.synthetic.main.connection_error_main.view.*
import kotlinx.android.synthetic.main.post_item.view.*

class LatestPostFragment: BaseFragment() {
    private lateinit var binding: FragmentLatestPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLatestPostBinding.inflate(inflater, container, false)
        binding.post.post_loader?.isVisible = true
        binding.viewModel = ViewModelProvider(this).get(LatestPostViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.next.setOnClickListener {
            nextClickHandle()
        }

        binding.previous.setOnClickListener {
            prevClickHandle()
        }

        binding.viewModel?.currentPost?.observe(viewLifecycleOwner) {
            onLoadPost(it)
        }

        binding.viewModel?.getCurrentIndex()?.observe(viewLifecycleOwner) {
            binding.previous.isEnabled = it > 0
        }

        binding.error.repeat_btn.setOnClickListener {
            onRepeatButtonClick()
        }
    }

    private fun onRepeatButtonClick() {
        binding.error.isVisible = false
        nextClickHandle()
    }

    private fun onLoadPost(it: Post?) {
        if(it == null) {
            binding.post.post_loader?.isVisible = false
            binding.notFound.isVisible = true
            return
        }

        it.gifURL?.let { url ->
            loadImage(url)
        }

        it.description?.let { description ->
            binding.post.post_text.text = description
        }
    }

    private fun prevClickHandle() {
        binding.viewModel?.loadPrevPost()
    }

    private fun nextClickHandle() {
        binding.post.post_loader?.isVisible = true
        if (checkNetworkConnection()) {
            binding.viewModel?.loadNextPost()
        } else {
            binding.post.post_loader?.isVisible = false
            binding.error.isVisible = true
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
                        binding.post.post_loader?.isVisible = false
                        binding.error.isVisible = true
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
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.post.post_image)
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