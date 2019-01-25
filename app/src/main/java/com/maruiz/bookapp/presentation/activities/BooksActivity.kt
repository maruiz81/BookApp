package com.maruiz.bookapp.presentation.activities

import android.content.Context
import android.content.Intent
import com.maruiz.bookapp.presentation.fragments.BaseFragment
import com.maruiz.bookapp.presentation.fragments.BooksFragment

class BooksActivity : BaseActivity() {
    override fun fragment(): BaseFragment = BooksFragment()

    companion object {
        fun callingIntent(context: Context) = Intent(context, BooksActivity::class.java)
    }
}