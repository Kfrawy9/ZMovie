package com.kfrawy.core.component.model

data class Cast(
    val id: Int,
    val name: String,
    val profile_path: String? = "",
    val credit_id: String,
    val character: String,
    val order: Int,
)

data class CastResult(
    val id: Int,
    val cast: List<Cast>,
)

