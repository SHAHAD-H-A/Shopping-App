package com.shahad.app.shoppingapp.domain.usecase.usecases.fashion

import com.shahad.app.shoppingapp.domain.entity.Brand
import com.shahad.app.shoppingapp.domain.repostiories.ShoppingRepository
import com.shahad.app.shoppingapp.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class BrandsUseCase @Inject constructor(
    private val shoppingRepository: ShoppingRepository
): BaseUseCase() {
    suspend operator fun invoke(): List<Brand> {
       return tryTo { shoppingRepository.getBrands() }
    }
}