package com.shahad.app.shoppingapp.domain.entity


data class Product(
    val brandName: String,
    val category: String,
    val discount: Int,
    val id: Int,
    val imageUrl: String,
    val isDiscount: Boolean,
    val isNew: Boolean,
    val name: String,
    val price: Int,
    val rating: Double
)