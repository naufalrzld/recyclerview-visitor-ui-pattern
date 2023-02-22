package com.example.visitablepattern.data

import com.example.visitablepattern.base.VisitorUIModel
import com.example.visitablepattern.data.response.Product
import com.example.visitablepattern.ui.adapter.VisitorElement

data class ProductData(
    val products: List<Product>
): VisitorUIModel() {
    override fun type(type: VisitorElement): Int {
        return type.visit(this)
    }
}
