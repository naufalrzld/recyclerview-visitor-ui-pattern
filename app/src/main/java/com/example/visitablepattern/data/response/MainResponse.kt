package com.example.visitablepattern.data.response

import com.google.gson.annotations.SerializedName

data class MainResponse(
    val success: Boolean,
    val data: Data,
    val message: String
)

data class Data(
    val ovo: Ovo,
    @SerializedName("payment_categories")
    val paymentCategories: List<Category> = emptyList(),
    val products: List<Product> = emptyList()
)