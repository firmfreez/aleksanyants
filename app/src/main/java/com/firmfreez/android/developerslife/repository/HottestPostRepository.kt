package com.firmfreez.android.developerslife.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.services.HottestPostService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HottestPostRepository @Inject constructor() {
    @Inject
    lateinit var hottestPostService: HottestPostService

    private val postList: ArrayList<Post> = ArrayList()
    private val _currentIndex: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = -1 }
    val currentIndex: LiveData<Int> = _currentIndex
    private var currentPage = 0

    suspend fun getNextHottestPost(): Post? {
        val newValue = (currentIndex.value ?: -1) + 1
        return if(newValue >= postList.count()) {
            val post = hottestPostService.getHottestPosts(currentPage)
            post?.result?.let {
                if(it.count() == 0) {
                    return null
                }
                currentPage++
                _currentIndex.postValue(newValue)
                postList.addAll(it)
                postList[newValue]
            }?: null
        } else {
            _currentIndex.postValue(newValue)
            postList[newValue]
        }
    }

    fun getPreviousPost(): Post? {
        val value = (currentIndex.value ?: -1)
        if(value > 0 && postList.count() > currentIndex.value ?: -1) {
            _currentIndex.value = value - 1
            return postList[value - 1]
        }
        return null
    }
}