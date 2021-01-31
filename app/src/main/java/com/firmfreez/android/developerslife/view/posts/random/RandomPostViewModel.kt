package com.firmfreez.android.developerslife.view.posts.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firmfreez.android.developerslife.di.App
import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.repository.RandomPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RandomPostViewModel: ViewModel() {
    @Inject lateinit var repository: RandomPostRepository
    private val _currentPost: MutableLiveData<Post?> = MutableLiveData<Post?>()
    val currentPost: LiveData<Post?> = _currentPost

    init {
        App.instance.component?.inject(this)

        loadNextPost()
    }

    fun loadNextPost() {
        CoroutineScope(Dispatchers.IO).launch {
            val post = repository.getNextRandomPost()
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