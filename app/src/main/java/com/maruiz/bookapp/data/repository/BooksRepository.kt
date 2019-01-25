package com.maruiz.bookapp.data.repository

import arrow.core.Either
import com.maruiz.bookapp.data.errors.Failure
import com.maruiz.bookapp.data.extensions.makeRequest
import com.maruiz.bookapp.data.model.BookModel
import com.maruiz.bookapp.data.service.Bookservice.BookApi


sealed class BooksRepository {
    abstract fun books(): Either<Failure, List<BookModel>>

    class Network(private val service: BookApi) : BooksRepository() {
        override fun books(): Either<Failure, List<BookModel>> = service.getBooks().makeRequest({ it }, emptyList())
    }
}
