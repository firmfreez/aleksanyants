package com.firmfreez.android.developerslife.view.posts.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firmfreez.android.developerslife.di.App
import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.repository.LatestPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LatestPostViewModel: ViewModel() {
    @Inject
    lateinit var repository: LatestPostRepository
    private val _currentPost: MutableLiveData<Post?> = MutableLiveData<Post?>()
    val currentPost: LiveData<Post?> = _currentPost

    init {
        App.instance.component?.inject(this)
    }

    fun loadNextPost() {
        CoroutineScope(Dispatchers.IO).launch {
            val post = repository.getNextLatestPost()
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