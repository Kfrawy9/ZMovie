package com.kfrawy.core.component.model

data class ViewState<T>(
    val loading: Boolean,
    val data: T,
    val error: String,
    val empty: Boolean,
)
