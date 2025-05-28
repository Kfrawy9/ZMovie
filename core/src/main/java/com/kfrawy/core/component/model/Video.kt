package com.kfrawy.core.component.model

data class Video(
    val name:String,
    val key: String,
    val site: String,
    val size: Int,
    val id: String,
)

data class VideoResult(
    val id: Int,
    val results: List<Video>,
)

