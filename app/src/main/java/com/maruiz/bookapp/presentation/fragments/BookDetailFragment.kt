package com.maruiz.bookapp.presentation.fragments

import com.maruiz.bookapp.R.layout
import com.maruiz.bookapp.presentation.recyclerview.BookView

class BookDetailFragment() : BaseFragment() {
    override val layoutId = layout.fragment_book_detail

    companion object {
        fun newInstance(bookView: BookView): BookDetailFragment =
            BookDetailFragment().apply {  }
    }
}