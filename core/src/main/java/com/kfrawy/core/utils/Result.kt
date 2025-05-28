package com.kfrawy.core.utils

import java.util.Objects

sealed class Result<T>{

    class Success<T>(val result: T): Result<T>()
    class Error<T>(val error: ErrorTypes): Result<T>()
    class Loading<T>: Result<T>()


}