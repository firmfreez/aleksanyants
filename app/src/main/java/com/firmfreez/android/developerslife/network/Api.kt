package com.firmfreez.android.developerslife.network

import com.firmfreez.android.developerslife.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("random?json=true")
    suspend fun getRandomPost(): Response<Post>

    companion object {
        const val BACK_URL = "https://developerslife.ru/"
    }
}