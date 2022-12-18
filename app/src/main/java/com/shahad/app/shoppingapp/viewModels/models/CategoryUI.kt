package com.shahad.app.shoppingapp.viewModels.models

import com.shahad.app.shoppingapp.domain.entity.Product

data class CategoryUI(
    val id: Int,
    val description: String,
    val title: String,
    val content: List<ProductUI>,
)