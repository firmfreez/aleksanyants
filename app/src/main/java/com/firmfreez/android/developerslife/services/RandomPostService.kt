package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.Post
import javax.inject.Inject

class RandomPostService @Inject constructor(): ApiService() {
    /**
     * Возвращает случайный пост
     */
    suspend fun getRandomPost(): Post? {
        return execute { api.getRandomPost() }
    }
}