package com.example.visitablepattern.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.visitablepattern.R
import com.example.visitablepattern.base.AbstractViewHolder
import com.example.visitablepattern.data.ProductData
import com.example.visitablepattern.data.response.Product
import com.example.visitablepattern.databinding.ItemProductBinding
import com.example.visitablepattern.databinding.ItemProductsBinding
import com.example.visitablepattern.utils.CurrencyUtil

class ProductsViewHolder(view: View) : AbstractViewHolder<ProductData>(view) {

    private val binding = ItemProductsBinding.bind(view)

    override fun onBind(data: ProductData) {
        val categoryAdapter = ProductAdapter(data.products)
        binding.rvProduct.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(binding.root.context, 2)
            adapter = categoryAdapter
        }
    }

    class ProductAdapter(
        val items: List<Product>
    ) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                ItemProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount() = items.size

        class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(product: Product) {
                Glide.with(binding.root).load(product.image).into(binding.ivProduct)
                binding.tvProductName.text = product.productName
                binding.tvPrice.text = CurrencyUtil.toIDR(product.price)
                binding.tvSold.text = "${product.sold}"
            }
        }

    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_products
    }
}