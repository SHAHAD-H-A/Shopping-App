package com.shahad.app.shoppingapp.viewModels.mappers

import com.shahad.app.shoppingapp.domain.entity.Category
import com.shahad.app.shoppingapp.domain.entity.Product
import com.shahad.app.shoppingapp.viewModels.models.CategoryUI
import com.shahad.app.shoppingapp.viewModels.models.ProductUI

fun Category.toCategoryUI(): CategoryUI {
    return CategoryUI(
        id = this.id,
        title = this.title,
        description =  this.description,
        content = this.content.map { it.toProductUI() }
    )
}

fun Product.toProductUI(): ProductUI {
    return ProductUI(
        id = this.id,
        name = this.name,
        brandName = this.brandName,
        imageUrl = this.imageUrl,
        pop = if(this.isNew) "New" else this.getDiscountPercent(),
        discount = if(isDiscount) this.discount else 0,
        isDiscount = this.isDiscount,
        price = this.price,
        rating = this.rating
    )
}

private fun Product.getDiscountPercent(): String {
    return "-${((price - discount) / price) * 100}%"
}
