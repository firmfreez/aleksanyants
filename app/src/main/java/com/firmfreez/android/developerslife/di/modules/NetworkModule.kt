package com.firmfreez.android.developerslife.di.modules

import com.firmfreez.android.developerslife.network.Api
import com.firmfreez.android.developerslife.network.UnsafeOkHttpClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return UnsafeOkHttpClient.getUnsafeOkHttpClient()
    }

    fun provideApi(gson: Gson, okHttpClient: OkHttpClient): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BACK_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))

        return retrofit.build().create(Api::class.java)
    }
}