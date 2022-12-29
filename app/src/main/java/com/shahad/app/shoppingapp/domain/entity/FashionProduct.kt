package com.shahad.app.shoppingapp.domain.entity

import com.shahad.app.shoppingapp.domain.util.FashionCategory
import com.shahad.app.shoppingapp.domain.util.FashionGroup

data class FashionProduct(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val colors: List<String>,
    val sizes: List<String>,
    val images: List<String>,
    val fullDescription: String,
    var category: FashionCategory,
    val group: FashionGroup,
)
