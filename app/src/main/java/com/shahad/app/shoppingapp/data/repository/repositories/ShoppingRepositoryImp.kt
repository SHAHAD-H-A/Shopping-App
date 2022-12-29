package com.shahad.app.shoppingapp.data.repository.repositories

import com.shahad.app.shoppingapp.data.mapper.toBrand
import com.shahad.app.shoppingapp.data.mapper.toCategory
import com.shahad.app.shoppingapp.data.mapper.toFashionProduct
import com.shahad.app.shoppingapp.data.remote.ShoppingService
import com.shahad.app.shoppingapp.data.repository.BaseRepository
import com.shahad.app.shoppingapp.domain.entity.Brand
import com.shahad.app.shoppingapp.domain.entity.Category
import com.shahad.app.shoppingapp.domain.entity.FashionProduct
import com.shahad.app.shoppingapp.domain.repostiories.ShoppingRepository
import javax.inject.Inject

class ShoppingRepositoryImp @Inject constructor(
    private val shoppingService: ShoppingService
): ShoppingRepository, BaseRepository {

    override suspend fun getSaleCategory(limit: Int): Category? {
        return tryTo { shoppingService.getSaleCategory(limit) }?.toCategory()
    }

    override suspend fun getNewCategory(limit: Int): Category? {
        return  tryTo { shoppingService.getNewCategory(limit) }?.toCategory()
    }

    override suspend fun getClothesCategory(limit: Int): Category? {
        return  tryTo { shoppingService.getClothesCategory(limit) }?.toCategory()
    }

    override suspend fun getShoesCategory(limit: Int): Category? {
        return  tryTo { shoppingService.getShoesCategory(limit) }?.toCategory()
    }

    override suspend fun getAccessoriesCategory(limit: Int): Category? {
        return  tryTo { shoppingService.getAccessoriesCategory(limit) }?.toCategory()
    }

    override suspend fun getNewArrival(): List<FashionProduct>? {
        return tryTo { shoppingService.getNewArrival() }?.map { it.toFashionProduct() }
    }

    override suspend fun getBrands(): List<Brand>? {
        return tryTo { shoppingService.getBrands() }?.map { it.toBrand() }
    }

    override suspend fun getRecommendedForYou(): List<FashionProduct>? {
        return tryTo { shoppingService.getRecommendedForYou() }?.map { it.toFashionProduct() }
    }

}