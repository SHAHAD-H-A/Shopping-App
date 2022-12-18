package com.shahad.app.shoppingapp.data.mapper

import com.shahad.app.shoppingapp.data.remote.response.CategoryDTO
import com.shahad.app.shoppingapp.data.remote.response.ProductDTO
import com.shahad.app.shoppingapp.domain.entity.Category
import com.shahad.app.shoppingapp.domain.entity.Product


fun CategoryDTO.toCategory(): Category {
    return Category(
        id = this.id ?: 0,
        title = this.title ?: "UNKNOWN TITLE",
        description = this.description ?: "UNKNOWN DESCRIPTION",
        content = this.content?.map{ it.toProduct() } ?: emptyList()
    )
}

fun ProductDTO.toProduct(): Product{
   return Product(
        id = this.id ?: 0,
        brandName = this.brandName ?: "BRAND NAME",
        category = this.category ?: "CATEGORY",
        price = this.price ?: 0,
        discount = this.discount ?: 0,
        isDiscount = this.isDiscount ?: false,
        imageUrl = this.imageUrl ?: "",
        rating = this.rating ?: 0.0,
        isNew = this.isNew ?: false,
        name = this.name ?: "NAME"
    )
}