package com.gutenberg.books.ui.books_list

import androidx.lifecycle.*
import com.gutenberg.books.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    val repository: BookRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    val liveData = MutableLiveData<String>()



}