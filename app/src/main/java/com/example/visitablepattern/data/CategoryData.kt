package com.example.visitablepattern.data

import com.example.visitablepattern.base.VisitorUIModel
import com.example.visitablepattern.data.response.Category
import com.example.visitablepattern.ui.adapter.VisitorElement

data class CategoryData(
    val categories: List<Category>
): VisitorUIModel() {
    override fun type(type: VisitorElement): Int {
        return type.visit(this)
    }

}
