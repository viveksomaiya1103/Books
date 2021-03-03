package com.gutenberg.books.ui.category_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gutenberg.books.R
import com.gutenberg.books.data.model.Category

class CategoryViewModel constructor() : ViewModel() {

    fun fetchCategoryList(): Array<Category> {
        return arrayOf(
            Category("Fiction", R.drawable.fiction),
            Category("Drama", R.drawable.drama),
            Category("Humor", R.drawable.humour),
            Category("Politics", R.drawable.politics),
            Category("Philosophy", R.drawable.philosophy),
            Category("History", R.drawable.history),
            Category("Adventure", R.drawable.adventure)
        )
    }

    private val _navigateToBooksList = MutableLiveData<String?>()
    val navigateToBooksList
        get() = _navigateToBooksList

    fun navigateToBooksScreen(categoryName : String){
        _navigateToBooksList.value = categoryName
    }
    fun doneNavigating() {
        _navigateToBooksList.value = null
    }

}