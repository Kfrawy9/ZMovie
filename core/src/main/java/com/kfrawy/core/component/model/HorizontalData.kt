package com.kfrawy.core.component.model

data class HorizontalData(
    val id: Int,
    val title: String,
    val url: String,
    val rating: Double,
    val year: Int,
    var bookmarked: Boolean = false,
)
