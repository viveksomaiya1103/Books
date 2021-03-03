package com.gutenberg.books.ui.books_list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.gutenberg.books.BookActivity
import com.gutenberg.books.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookList : Fragment(R.layout.book_list_fragment) {

    private val viewModel: BookListViewModel by viewModels()
    val nav by navArgs<BookListArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as BookActivity).title= nav.categoryName



    }



}