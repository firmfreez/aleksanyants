package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.PostPage
import java.lang.Exception
import javax.inject.Inject

class LatestPostService @Inject constructor(): ApiService() {
    suspend fun getLatestPosts(page: Int): PostPage? {
        return try {
            execute { api.getLatestPosts(page) }
        } catch (e: Exception) {
            null
        }
    }
}