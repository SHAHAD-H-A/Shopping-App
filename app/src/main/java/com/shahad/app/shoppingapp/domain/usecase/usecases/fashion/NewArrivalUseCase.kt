package com.shahad.app.shoppingapp.domain.usecase.usecases.fashion

import com.shahad.app.shoppingapp.domain.entity.FashionProduct
import com.shahad.app.shoppingapp.domain.repostiories.ShoppingRepository
import com.shahad.app.shoppingapp.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class NewArrivalUseCase @Inject constructor(
    private val shoppingRepository: ShoppingRepository
): BaseUseCase() {
    suspend operator fun invoke(): List<FashionProduct> {
       return tryTo { shoppingRepository.getNewArrival() }
    }
}