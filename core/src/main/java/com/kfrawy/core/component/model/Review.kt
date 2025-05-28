package com.kfrawy.core.component.model

data class Review(
    val author: String,
    val author_details: AuthorDetails,
    val content: String,
    val created_at: String,
    val id: String,
    val url: String,
)

data class AuthorDetails(
    val name: String,
    val username: String,
    val avatar_path: String?,
    val rating: Int? = 0,
)

data class ReviewResult(
    val id: Int,
    val page: Int,
    val results: List<Review>,
)

