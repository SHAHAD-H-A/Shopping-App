package com.shahad.app.shoppingapp.viewModels.models

data class ProductUI(
    val id: Int,
    val name: String,
    val brandName: String,
    val imageUrl: String,
    val pop: String,
    val discount: Int,
    val isDiscount: Boolean,
    val price: Int,
    val rating: Double
)
