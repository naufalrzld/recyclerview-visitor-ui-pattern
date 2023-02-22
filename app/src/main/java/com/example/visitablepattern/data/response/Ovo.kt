package com.example.visitablepattern.data.response

import com.example.visitablepattern.base.VisitorUIModel
import com.example.visitablepattern.ui.adapter.VisitorElement

data class Ovo(
    val amount: Int,
    val point: Int
): VisitorUIModel() {
    override fun type(type: VisitorElement): Int {
        return type.visit(this)
    }
}
