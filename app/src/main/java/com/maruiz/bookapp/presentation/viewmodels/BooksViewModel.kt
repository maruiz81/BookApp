package com.maruiz.bookapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import arrow.core.None
import com.maruiz.bookapp.data.model.BookModel
import com.maruiz.bookapp.domain.GetBooks
import com.maruiz.bookapp.presentation.recyclerview.BookView

class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {

    private val books = MutableLiveData<List<BookView>>()

    fun observeBooks(): LiveData<List<BookView>> = books

    fun getBooks() = getBooks(None) { it.fold(::handleFailure, ::handleSuccess) }

    private fun handleSuccess(books: List<BookModel>) {
        this.books.value = books.map { BookView(it.title, it.cover) }
    }

    override fun cancelRequest() {
        getBooks.cancel()
    }
}