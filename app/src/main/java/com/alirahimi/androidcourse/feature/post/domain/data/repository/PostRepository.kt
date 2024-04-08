package com.alirahimi.androidcourse.feature.post.domain.data.repository

import com.alirahimi.androidcourse.feature.post.domain.data.model.PostResponse
import com.alirahimi.androidcourse.shared_component.APIService

class PostRepository(private val api: APIService) {

    suspend fun getAllPosts(): Result<PostResponse> {
        val response = api.getAllPosts()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Throwable("سرویس خطا داشت"))
        } else {
            Result.failure(Throwable("سرویس انجام نشد"))
        }
    }
}