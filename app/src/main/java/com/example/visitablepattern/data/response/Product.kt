package com.example.visitablepattern.data.response

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("product_name")
    val productName: String,
    val price: Int,
    val sold: Int,
    val image: String
)
