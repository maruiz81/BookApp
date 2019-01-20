package com.maruiz.bookapp.data.errors

sealed class Error : Throwable {
    class NetworkConnection : Error()
    class ServerError : Error()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Error()
}