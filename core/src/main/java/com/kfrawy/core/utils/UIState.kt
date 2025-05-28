package com.kfrawy.core.utils

import com.kfrawy.core.component.model.HorizontalData

sealed class UIState {

    object Loading: UIState()
    class Success(val data: List<HorizontalData>): UIState()
    class Failure(val message: String): UIState()
}