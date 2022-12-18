package com.shahad.app.shoppingapp.domain.entity

data class Category(
    val content: List<Product>,
    val description: String,
    val id: Int,
    val title: String
)