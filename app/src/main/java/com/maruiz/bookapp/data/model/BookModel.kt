package com.maruiz.bookapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BookModel(val bookId: Int, val title: String, val synopsis: String)