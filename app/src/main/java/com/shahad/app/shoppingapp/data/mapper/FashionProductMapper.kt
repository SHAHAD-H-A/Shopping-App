package com.shahad.app.shoppingapp.data.mapper

import com.shahad.app.shoppingapp.data.remote.response.FashionProductDTO
import com.shahad.app.shoppingapp.domain.entity.FashionProduct
import com.shahad.app.shoppingapp.domain.util.FashionCategory
import com.shahad.app.shoppingapp.domain.util.FashionGroup

fun FashionProductDTO.toFashionProduct(): FashionProduct {
    return FashionProduct(
        id = this.id ?: 0,
        name = this.name ?: "UNKNOWN NAME",
        description = this.description ?: "UNKNOWN DESCRIPTION",
        price = this.price ?: 0,
        colors = this.colors ?: listOf(),
        sizes = this.sizes ?: listOf(),
        images = this.images ?: listOf(),
        fullDescription = StringBuilder().apply {
            if(this@toFashionProduct.material != null){
                append("MATERIALS \n")
                append(this@toFashionProduct.material)
            }
            if(this@toFashionProduct.care != null){
                  append("CARE \n")
                  append(this@toFashionProduct.care)
              }
        }.toString(),
        category = this.category.toFashionCategory(),
        group = this.group.toFashionGroup()
    )
}

private fun String?.toFashionGroup(): FashionGroup {
    return when(this){
        "WOMEN" -> FashionGroup.WOMEN
        "MEN" -> FashionGroup.MEN
        else -> FashionGroup.KIDS
    }
}

private fun String?.toFashionCategory(): FashionCategory {
    return when(this){
        "BAG" -> FashionCategory.BAG
        "SHOES" -> FashionCategory.SHOES
        "BEAUTY" -> FashionCategory.BEAUTY
        "ACCESSORIES" -> FashionCategory.ACCESSORIES
        "OUTER" -> FashionCategory.APPAREL.OUTER
        "DREES" -> FashionCategory.APPAREL.DREES
        "BLOUSE" -> FashionCategory.APPAREL.BLOUSE
        "T_SHIRT" -> FashionCategory.APPAREL.T_SHIRT
        "KNITWEAR" -> FashionCategory.APPAREL.KNITWEAR
        "SKIRT" -> FashionCategory.APPAREL.SKIRT
        "PANTS" -> FashionCategory.APPAREL.PANTS
        "DENIM" -> FashionCategory.APPAREL.DENIM
        else -> FashionCategory.NEW.ACCESSORIES
    }
}
