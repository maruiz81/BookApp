package com.maruiz.bookapp.presentation.app

import android.app.Application
import com.maruiz.bookapp.presentation.di.appModule
import org.koin.android.ext.android.startKoin

class BookApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule), loadPropertiesFromFile = true)
    }
}