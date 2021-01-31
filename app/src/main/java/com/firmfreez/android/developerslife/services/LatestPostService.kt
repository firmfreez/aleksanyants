package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.PostPage
import javax.inject.Inject

class LatestPostService @Inject constructor(): ApiService() {
    suspend fun getLatestPosts(page: Int): PostPage {
        return execute { api.getLatestPosts(page) }
    }
}