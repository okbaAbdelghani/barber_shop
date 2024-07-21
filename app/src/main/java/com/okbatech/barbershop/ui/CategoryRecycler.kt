package com.okbatech.barbershop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.okbatech.barbershop.data.Category
import com.okbatech.barbershop.databinding.ItemCategoryBinding

class CategoryRecycler(
    var listener: CategoryListener?
) : RecyclerView.Adapter<CategoryRecycler.BaseCategoryHolder>() {

    private var categories: List<Category> = ArrayList()


    fun setData(categories: List<Category>?) {
        this.categories = categories ?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoriesHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseCategoryHolder, position: Int) {
        holder.bind(categories[position], position)
    }

    override fun getItemCount() = categories.size

    inner class CategoriesHolder(private var binding: ItemCategoryBinding) :
        BaseCategoryHolder(binding.root), CategoryListener {

        override fun bind(category: Category, position: Int) {
            binding.tvCategoryTitle.text = category.name
        }

        override fun selectCategory(category: Category) {
        }
    }


    abstract inner class BaseCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(category: Category, position: Int)
    }

    interface CategoryListener {
        fun selectCategory(category: Category)
    }
}