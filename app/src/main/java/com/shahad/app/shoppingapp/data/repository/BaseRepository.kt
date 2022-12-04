package com.shahad.app.shoppingapp.data.repository

import android.util.Log
import com.shahad.app.shoppingapp.domain.repostiories.base.Repository
import retrofit2.Response


interface BaseRepository: Repository {

    suspend fun <T, U> refreshDataBase(
        request: suspend (Int) -> Response<T>,
        insertIntoDatabase: suspend (List<U>) -> Unit,
        numberOfResponse: Int,
        mapper: (T?) -> List<U>?,
    ) {
        try {
            request(numberOfResponse).also { response ->
                if (response.isSuccessful) {
                    val entities = mapper(response.body())
                    entities?.let { it ->
                        insertIntoDatabase(it)
                    }
                }
            }
        } catch (exception: Exception) {
            Log.i("MARVEL", "no connection cant update data")
        }
    }

}
