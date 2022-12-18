package com.shahad.app.shoppingapp.di

import com.shahad.app.shoppingapp.data.repository.repositories.ShoppingRepositoryImp
import com.shahad.app.shoppingapp.domain.repostiories.ShoppingRepository
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideRepository(
        impl: ShoppingRepositoryImp
    ): ShoppingRepository

}