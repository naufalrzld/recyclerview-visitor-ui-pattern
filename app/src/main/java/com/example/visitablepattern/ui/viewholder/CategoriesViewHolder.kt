package com.example.visitablepattern.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.visitablepattern.R
import com.example.visitablepattern.base.AbstractViewHolder
import com.example.visitablepattern.data.CategoryData
import com.example.visitablepattern.data.response.Category
import com.example.visitablepattern.databinding.ItemCategoriesBinding
import com.example.visitablepattern.databinding.ItemCategoryBinding

class CategoriesViewHolder(view: View) : AbstractViewHolder<CategoryData>(view) {

    private val binding = ItemCategoriesBinding.bind(view)

    override fun onBind(data: CategoryData) {
        val categoryAdapter = CategoryAdapter(data.categories)
        binding.rvCategory.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }

    class CategoryAdapter(
        val items: List<Category>
    ) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                ItemCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount() = items.size

        class ViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(category: Category) {
                Glide.with(binding.root).load(category.icon).into(binding.ivIcon)
                binding.tvCategory.text = category.category
            }
        }

    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_categories
    }
}