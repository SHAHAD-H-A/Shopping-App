package com.shahad.app.shoppingapp.viewModels.states

sealed class HomeStateScreen<out T> {
    object Initial: HomeStateScreen<Nothing>()
    class Success<T>(data: T): HomeStateScreen<T>()
}