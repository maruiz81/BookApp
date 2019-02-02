package com.maruiz.bookapp.presentation.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maruiz.bookapp.R.layout
import com.maruiz.bookapp.presentation.extensions.inflate
import kotlinx.android.synthetic.main.row_book.view.*
import kotlin.properties.Delegates

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    internal var books: List<BookView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal lateinit var clickListener: (BookView, View) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(layout.row_book))

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bookView: BookView, clickListener: (BookView, View) -> Unit) {
            itemView.title.text = bookView.title
            itemView.setOnClickListener { clickListener(bookView, itemView.cover) }
        }
    }
}