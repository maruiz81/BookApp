package com.maruiz.bookapp.data.extensions

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.core.Try
import com.maruiz.bookapp.data.errors.Failure
import retrofit2.Call

fun <T, R> Call<T>.makeRequest(transform: (T) -> R, default: T): Either<Failure, R> =
    Try {
        this.execute().let {
            if (it.isSuccessful) Right(it.body())
            else Left(Failure.ServerError())
        }
    }.fold({ Left(Failure.ServerError()) }, { it.map { transform((it ?: default)) } })
