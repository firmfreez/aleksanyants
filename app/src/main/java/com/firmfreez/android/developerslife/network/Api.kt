package com.firmfreez.android.developerslife.network

import com.firmfreez.android.developerslife.models.Post
import com.firmfreez.android.developerslife.models.PostPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("random?json=true")
    suspend fun getRandomPost(): Response<Post?>

    @GET("latest/{page_id}?json=true")
    suspend fun getLatestPosts(@Path(value = "page_id", encoded = true) page: Int): Response<PostPage?>

    @GET("hot/{page_id}?json=true")
    suspend fun getHottestPosts(@Path(value = "page_id", encoded = true) page: Int): Response<PostPage?>

    @GET("top/{page_id}?json=true")
    suspend fun getBestPosts(@Path(value = "page_id", encoded = true) page: Int): Response<PostPage?>

    companion object {
        const val BACK_URL = "https://developerslife.ru/"
    }
}