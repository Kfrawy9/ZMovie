package com.kfrawy.core.component.model

data class Image(
    val width: Int,
    val height: Int,
    val file_path: String,
    val aspect_ratio: Double,
)

data class ImageResult(
    val backdrops: List<Image>,
)

