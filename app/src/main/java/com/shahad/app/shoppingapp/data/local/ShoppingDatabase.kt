package com.shahad.app.shoppingapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shahad.app.shoppingapp.data.local.entities.CharacterEntity

@TypeConverters(Convertor::class)
@Database(entities = [CharacterEntity::class] , version = 1)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao

    companion object{
        const val DATABASE_NAME = "SHOPPING_APP_DATABASE"
    }

}