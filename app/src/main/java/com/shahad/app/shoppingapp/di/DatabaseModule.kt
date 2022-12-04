package com.shahad.app.shoppingapp.di

import android.content.Context
import androidx.room.Room
import com.shahad.app.shoppingapp.data.local.ShoppingDao
import com.shahad.app.shoppingapp.data.local.ShoppingDatabase
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ShoppingDatabase =
        Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            ShoppingDatabase.DATABASE_NAME
        ).build()


    @Singleton
    @Provides
    fun provideDao(database: ShoppingDatabase): ShoppingDao =
        database.shoppingDao()

}