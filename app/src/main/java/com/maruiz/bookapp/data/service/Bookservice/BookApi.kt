package com.maruiz.bookapp.data.service.Bookservice

import com.maruiz.bookapp.data.model.BookModel
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {
    @GET("BookList.json") fun getBooks() : Call<List<BookModel>>
}