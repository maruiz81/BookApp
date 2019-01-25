package com.maruiz.bookapp.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maruiz.bookapp.R.id
import com.maruiz.bookapp.R.layout
import com.maruiz.bookapp.presentation.extensions.inTransaction
import com.maruiz.bookapp.presentation.fragments.BaseFragment
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_layout)
        setSupportActionBar(toolbar)
        savedInstanceState ?: addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.inTransaction { add(id.fragmentContainer, fragment()) }
    }

    abstract fun fragment(): BaseFragment
}