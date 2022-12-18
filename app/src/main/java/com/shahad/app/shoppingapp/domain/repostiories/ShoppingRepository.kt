package com.shahad.app.shoppingapp.domain.repostiories

import com.shahad.app.shoppingapp.domain.entity.Category

interface ShoppingRepository{
    suspend fun getSaleCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getNewCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getClothesCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getShoesCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getAccessoriesCategory(limit: Int = DEFAULT_LIMIT): Category?

    companion object{
        const val DEFAULT_LIMIT = 10
    }
}