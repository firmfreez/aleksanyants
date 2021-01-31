package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.PostPage
import java.lang.Exception
import javax.inject.Inject

class BestPostService @Inject constructor(): ApiService() {
    suspend fun getBestPosts(page: Int): PostPage? {
        return try {
            execute { api.getBestPosts(page) }
        } catch (e: Exception) {
            null
        }
    }
}