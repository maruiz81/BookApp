package com.maruiz.bookapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.maruiz.bookapp.R
import com.maruiz.bookapp.presentation.recyclerview.BookAdapter
import com.maruiz.bookapp.presentation.viewmodels.BooksViewModel
import kotlinx.android.synthetic.main.fragment_books.*
import org.koin.android.ext.android.inject


class BooksFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_books

    val bookAdapter: BookAdapter by inject()

    val booksViewModel: BooksViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        booksViewModel.observeBooks().observe(this, Observer { it?.let { bookAdapter.books = it } })
        booksViewModel.observeFailure().observe(this, Observer {
            it?.let { getView()?.let { Snackbar.make(it, R.string.error_request_books, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry, View.OnClickListener { booksViewModel.getBooks() }).show() } } })
        initRecyclerView()

        booksViewModel.getBooks()
    }

    private fun initRecyclerView() {
        bookList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        bookList.adapter = bookAdapter.apply {
            clickListener = { bookView, view ->
                activity?.supportFragmentManager?.beginTransaction()
                    ?.addSharedElement(view, "shared_image")
                    ?.replace(R.id.fragmentContainer, BookDetailFragment.newInstance(bookView))
            }
        }
    }
}