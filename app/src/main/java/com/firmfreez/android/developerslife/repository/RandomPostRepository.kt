package com.firmfreez.android.developerslife.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.services.RandomPostService
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomPostRepository @Inject constructor() {
    @Inject lateinit var randomPostService: RandomPostService

    private val postList: ArrayList<Post> = ArrayList()
    private val _currentIndex: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = -1 }
    val currentIndex: LiveData<Int> = _currentIndex

    suspend fun getNextRandomPost(): Post? {
        Timber.d("Index: %s", currentIndex.value)
        Timber.d("List length: %s", postList.count())
        val newValue = (currentIndex.value ?: -1) + 1
        return if(newValue >= postList.count()) {
            val post = randomPostService.getRandomPostOrNull()
            post?.let {
                _currentIndex.postValue(newValue)
                postList.add(it)
                it
            }?: null
        } else {
            _currentIndex.postValue(newValue)
            postList[newValue]
        }
    }

    fun getPreviousPost(): Post? {
        Timber.d("Index: %s", currentIndex.value)
        Timber.d("List length: %s", postList.count())
        val value = (currentIndex.value ?: -1)
        if(value > 0 && postList.count() > currentIndex.value ?: -1) {
            _currentIndex.value = value - 1
            return postList[value - 1]
        }
        return null
    }
}