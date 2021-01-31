package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.PostPage
import javax.inject.Inject

class BestPostService @Inject constructor(): ApiService() {
    suspend fun getBestPosts(page: Int): PostPage {
        return execute { api.getBestPosts(page) }
    }
}