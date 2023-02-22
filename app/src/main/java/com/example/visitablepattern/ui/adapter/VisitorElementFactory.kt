package com.example.visitablepattern.ui.adapter

import android.view.View
import com.example.visitablepattern.base.AbstractViewHolder
import com.example.visitablepattern.data.*
import com.example.visitablepattern.data.response.Ovo
import com.example.visitablepattern.ui.viewholder.CategoriesViewHolder
import com.example.visitablepattern.ui.viewholder.OvoViewHolder
import com.example.visitablepattern.ui.viewholder.ProductsViewHolder

class VisitorElementFactory : VisitorElement {
    override fun visit(data: Ovo): Int {
        return OvoViewHolder.LAYOUT
    }

    override fun visit(data: CategoryData): Int {
        return CategoriesViewHolder.LAYOUT
    }

    override fun visit(data: ProductData): Int {
        return ProductsViewHolder.LAYOUT
    }

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return when(type) {
            OvoViewHolder.LAYOUT -> OvoViewHolder(parent)
            CategoriesViewHolder.LAYOUT -> CategoriesViewHolder(parent)
            ProductsViewHolder.LAYOUT -> ProductsViewHolder(parent)
            else -> createViewHolder(parent, type)
        }
    }
}