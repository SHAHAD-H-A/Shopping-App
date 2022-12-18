package com.shahad.app.shoppingapp.domain.usecase.base

abstract class BaseUseCase{
    suspend inline fun <T> tryTo(noinline function : suspend () -> T?): T {
        return function() ?: throw Exception("No Response")
    }
}