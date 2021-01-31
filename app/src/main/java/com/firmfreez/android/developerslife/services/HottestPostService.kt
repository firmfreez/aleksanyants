package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.PostPage
import java.lang.Exception
import javax.inject.Inject

class HottestPostService @Inject constructor(): ApiService() {
    suspend fun getHottestPosts(page: Int): PostPage? {
        return try {
            execute { api.getHottestPosts(page) }
        } catch (e: Exception) {
            null
        }
    }
}