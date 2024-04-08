package com.alirahimi.androidcourse.shared_component

import com.alirahimi.androidcourse.feature.post.domain.data.model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    suspend fun getAllPosts(): Response<PostResponse>
}