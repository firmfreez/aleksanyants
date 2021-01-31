package com.firmfreez.android.developerslife.services

import com.firmfreez.android.developerslife.models.PostPage
import javax.inject.Inject

class HottestPostService @Inject constructor(): ApiService() {
    suspend fun getHottestPosts(page: Int): PostPage {
        return execute { api.getHottestPosts(page) }
    }
}