package com.alirahimi.androidcourse.feature.home.domain.data.model

data class Food(
    val subject: String,
    val price: String,
    val distance: String,
    val city: String,
    val image: Int,
    val numberOfRatings: Int,
    val rating: Float
)
