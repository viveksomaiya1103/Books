package com.gutenberg.books.ui.category_list


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.gutenberg.books.BookActivity
import com.gutenberg.books.R
import com.gutenberg.books.data.model.Category
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.category_list_fragment.*


@AndroidEntryPoint
class CategoryList : Fragment(R.layout.category_list_fragment) {

    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var mAdpater : CategoryAdapter
    private lateinit var mCategoryList : Array<Category>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as BookActivity).title= ""
        setup()
        dataObserver()
    }


    private fun dataObserver(){
        viewModel.navigateToBooksList.observe(viewLifecycleOwner, Observer {categoryName->
            categoryName?.let {
                navigate(it)
            }

        })


    }


    private  fun navigate(categoryName : String){
        Navigation.findNavController(requireView()).navigate(CategoryListDirections.actionCategoryListToBookList(categoryName))
        viewModel.doneNavigating()
    }




    private  fun setup(){
        mCategoryList = viewModel.fetchCategoryList()
        mAdpater = CategoryAdapter(mCategoryList, CategoryListener {categoryName ->
            categoryName.let {
                Toast.makeText(context,"$it",Toast.LENGTH_LONG).show()
                viewModel.navigateToBooksScreen(it)
            }


        })
        categoryList.adapter = mAdpater

    }





}