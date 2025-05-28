package com.kfrawy.core.utils

sealed class ErrorTypes {

    object EmptyData: ErrorTypes()
    class ServerError(val message: String): ErrorTypes()
    class ClientError(val message: String): ErrorTypes()

}

fun data(eror: ErrorTypes){
    when(eror){
        is ErrorTypes.ClientError -> {
        }
        ErrorTypes.EmptyData -> {

        }
        is ErrorTypes.ServerError -> {

        }
    }
}