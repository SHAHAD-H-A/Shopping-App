package com.shahad.app.shoppingapp.domain.usecase.usecases

import com.shahad.app.shoppingapp.domain.entity.Category
import com.shahad.app.shoppingapp.domain.repostiories.ShoppingRepository
import com.shahad.app.shoppingapp.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class SaleCategoryUseCase @Inject constructor(
    private val shoppingRepository: ShoppingRepository
): BaseUseCase() {
    suspend operator fun invoke(limit: Int): Category {
       return tryTo { shoppingRepository.getSaleCategory(limit) }
    }
}