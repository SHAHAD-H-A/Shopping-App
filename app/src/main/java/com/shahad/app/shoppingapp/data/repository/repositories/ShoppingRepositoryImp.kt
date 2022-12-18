package com.shahad.app.shoppingapp.data.repository.repositories

import com.shahad.app.shoppingapp.data.mapper.toCategory
import com.shahad.app.shoppingapp.data.remote.ShoppingService
import com.shahad.app.shoppingapp.data.repository.BaseRepository
import com.shahad.app.shoppingapp.domain.entity.Category
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

}