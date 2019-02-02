package com.maruiz.bookapp.presentation.di

import com.maruiz.bookapp.data.repository.BooksRepository
import com.maruiz.bookapp.data.service.Bookservice.BookApi
import com.maruiz.bookapp.domain.GetBooks
import com.maruiz.bookapp.presentation.recyclerview.BookAdapter
import com.maruiz.bookapp.presentation.viewmodels.BooksViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(getProperty<String>("base_url"))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(BookApi::class.java) }
    single<BooksRepository> { BooksRepository.Network(get()) }
    single { GetBooks(get()) }
    single { BookAdapter() }
    viewModel { BooksViewModel(get()) }
}