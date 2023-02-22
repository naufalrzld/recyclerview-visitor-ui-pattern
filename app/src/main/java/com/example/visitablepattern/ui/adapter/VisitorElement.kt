package com.example.visitablepattern.ui.adapter

import android.view.View
import com.example.visitablepattern.base.AbstractViewHolder
import com.example.visitablepattern.data.*
import com.example.visitablepattern.data.response.Ovo

interface VisitorElement {
    fun visit(data: Ovo): Int

    fun visit(data: CategoryData): Int

    fun visit(data: ProductData): Int

    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}