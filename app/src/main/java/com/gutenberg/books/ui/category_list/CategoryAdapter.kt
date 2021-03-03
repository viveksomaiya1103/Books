package com.gutenberg.books.ui.category_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gutenberg.books.data.model.Category
import com.gutenberg.books.databinding.CategoryCardBinding

class CategoryAdapter(val categoryList: Array<Category>, val categoryListener: CategoryListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        return CategoryViewHolder(
            CategoryCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position],categoryListener)
    }


    override fun getItemCount() = categoryList.size

    class CategoryViewHolder(val binding: CategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category, categoryListener: CategoryListener) {
            binding.category = category
            binding.clickListener = categoryListener
            binding.executePendingBindings()

        }

    }


}
class CategoryListener(val clickListener: (categoryName: String) -> Unit) {
    fun onClick(category: Category) = clickListener(category.categoryName)
}
