package com.shahad.app.shoppingapp.viewModels

import androidx.lifecycle.viewModelScope
import com.shahad.app.shoppingapp.domain.usecase.usecases.*
import com.shahad.app.shoppingapp.viewModels.mappers.toCategoryUI
import com.shahad.app.shoppingapp.viewModels.models.CategoryUI
import com.shahad.app.shoppingapp.viewModels.states.HomeStateScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saleCategoryUseCase: SaleCategoryUseCase,
    private val newCategoryUseCase: NewCategoryUseCase,
    private val clothesCategoryUseCase: ClothesCategoryUseCase,
    private val shoesCategoryUseCase: ShoesCategoryUseCase,
    private val accessoriesCategoryUseCase: AccessoriesCategoryUseCase
): BaseViewModel() {

    val saleCategory = MutableStateFlow<HomeStateScreen<CategoryUI>>(HomeStateScreen.Initial)
    val clothesCategory = MutableStateFlow<HomeStateScreen<CategoryUI>>(HomeStateScreen.Initial)
    val shoesCategory = MutableStateFlow<HomeStateScreen<CategoryUI>>(HomeStateScreen.Initial)
    val newCategory = MutableStateFlow<HomeStateScreen<CategoryUI>>(HomeStateScreen.Initial)
    val accessoriesCategory = MutableStateFlow<HomeStateScreen<CategoryUI>>(HomeStateScreen.Initial)

    init {
        getSaleCategory()
        getNewCategory()
        getShoesCategory()
        getAccessoriesCategory()
        getClothesCategory()
    }

    private fun getSaleCategory() {
        wrapWithHomeState(saleCategory){
            saleCategoryUseCase.invoke(NUMBER_OF_PRODUCT).toCategoryUI()
        }
    }
    private fun getNewCategory() {
        wrapWithHomeState(newCategory) {
            newCategoryUseCase.invoke(NUMBER_OF_PRODUCT).toCategoryUI()
        }
    }
    private fun getAccessoriesCategory() {
        wrapWithHomeState(accessoriesCategory){
            accessoriesCategoryUseCase.invoke(NUMBER_OF_PRODUCT).toCategoryUI()
        }
    }
    private fun getShoesCategory() {
        wrapWithHomeState(shoesCategory){
            shoesCategoryUseCase.invoke(NUMBER_OF_PRODUCT).toCategoryUI()
        }
    }
    private fun getClothesCategory() {
        wrapWithHomeState(clothesCategory){
            clothesCategoryUseCase.invoke(NUMBER_OF_PRODUCT).toCategoryUI()
        }
    }


    private  fun <T> wrapWithHomeState(state: MutableStateFlow<HomeStateScreen<T>>,request: suspend () -> T) {
        viewModelScope.launch{
            try {
                val result = request()
                state.value = result.toHomeState()
            } catch (e: Exception) {

            }
        }
    }
    private inline fun <T> T.toHomeState(): HomeStateScreen<T>  = HomeStateScreen.Success(this)

    companion object {
        const val NUMBER_OF_PRODUCT = 10
    }
}


