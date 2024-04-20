package com.alirahimi.androidcourse.shared_component.api

import com.alirahimi.androidcourse.shared_component.api.API.Companion.Constants.baseURL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class API {

    companion object {
        private val myAppClient: OkHttpClient
            get() = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .readTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .connectTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .build()

        private val apiBuilder: Retrofit.Builder
            get() = Retrofit.Builder()
                .client(myAppClient)
                .addConverterFactory(GsonConverterFactory.create(gson))

        val baseUserService: APIService by lazy {
            apiBuilder
                .baseUrl(baseURL)
                .build()
                .create(APIService::class.java)
        }

        private val gson: Gson get() = GsonBuilder().setLenient().create()

        private val interceptor: HttpLoggingInterceptor
            get() = HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }

        private object Constants {
            const val baseURL = "https://jsonplaceholder.typicode.com/"
            const val connectionTime: Long = 60
        }
    }
}