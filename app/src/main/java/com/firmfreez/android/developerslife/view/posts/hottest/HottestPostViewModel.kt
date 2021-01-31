package com.firmfreez.android.developerslife.view.posts.hottest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firmfreez.android.developerslife.di.App
import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.repository.HottestPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HottestPostViewModel: ViewModel() {
    @Inject
    lateinit var repository: HottestPostRepository
    private val _currentPost: MutableLiveData<Post?> = MutableLiveData<Post?>()
    val currentPost: LiveData<Post?> = _currentPost

    init {
        App.instance.component?.inject(this)

        loadNextPost()
    }

    fun loadNextPost() {
        CoroutineScope(Dispatchers.IO).launch {
            val post = repository.getNextHottestPost()
            _currentPost.postValue(post)
        }
    }

    fun loadPrevPost() {
        repository.getPreviousPost()?.let {
            _currentPost.value = it
        }
    }

    fun getCurrentIndex(): LiveData<Int> {
        return repository.currentIndex
    }
}