package com.maruiz.bookapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import arrow.core.None
import com.maruiz.bookapp.data.model.BookModel
import com.maruiz.bookapp.domain.GetBooks

class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {

    val books = MutableLiveData<List<BookModel>>()

    fun loadBooks() = getBooks(None) { it.fold(::handleFailure, ::handleSuccess) }

    private fun handleSuccess(books: List<BookModel>) {
        this.books.value = books
    }

    override fun cancelRequest() {
        getBooks.cancel()
    }
}