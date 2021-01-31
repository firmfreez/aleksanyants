package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.Post
import java.lang.Exception
import javax.inject.Inject

class RandomPostService @Inject constructor(): ApiService() {
    /**
     * Возвращает случайный пост
     */
    suspend fun getRandomPostOrNull(): Post? {
        return try {
            execute { api.getRandomPost() }
        } catch (e: Exception) {
            null
        }

    }
}