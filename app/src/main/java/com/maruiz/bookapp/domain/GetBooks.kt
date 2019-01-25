package com.maruiz.bookapp.domain

import arrow.core.Either
import arrow.core.None
import com.maruiz.bookapp.data.errors.Failure
import com.maruiz.bookapp.data.model.BookModel
import com.maruiz.bookapp.data.repository.BooksRepository

class GetBooks(private val booksRepository: BooksRepository) : UseCase<List<BookModel>, None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> = booksRepository.books()
}