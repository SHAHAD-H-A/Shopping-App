package com.shahad.app.shoppingapp.domain.util


sealed class  FashionCategory {
    object BAG: FashionCategory()
    object SHOES: FashionCategory()
    object BEAUTY: FashionCategory()
    object ACCESSORIES: FashionCategory()
    sealed class APPAREL: FashionCategory() {
        object OUTER: APPAREL()
        object DREES: APPAREL()
        object BLOUSE: APPAREL()
        object T_SHIRT: APPAREL()
        object KNITWEAR: APPAREL()
        object SKIRT: APPAREL()
        object PANTS: APPAREL()
        object DENIM: APPAREL()
    }
    sealed class NEW: FashionCategory(){
        object BAG: NEW()
        object SHOES: NEW()
        object APPAREL: NEW()
        object ACCESSORIES: NEW()
    }
}