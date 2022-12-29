package com.shahad.app.shoppingapp.domain.repostiories

import com.shahad.app.shoppingapp.data.remote.response.BrandDTO
import com.shahad.app.shoppingapp.domain.entity.Brand
import com.shahad.app.shoppingapp.domain.entity.Category
import com.shahad.app.shoppingapp.domain.entity.FashionProduct

interface ShoppingRepository{
    suspend fun getSaleCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getNewCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getClothesCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getShoesCategory(limit: Int = DEFAULT_LIMIT): Category?
    suspend fun getAccessoriesCategory(limit: Int = DEFAULT_LIMIT): Category?

    suspend fun getNewArrival(): List<FashionProduct>?
    suspend fun getBrands(): List<Brand>?
    suspend fun getRecommendedForYou(): List<FashionProduct>?
    companion object{
        const val DEFAULT_LIMIT = 10
    }
}