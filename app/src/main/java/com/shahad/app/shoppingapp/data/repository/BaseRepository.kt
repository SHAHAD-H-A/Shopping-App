package com.shahad.app.shoppingapp.data.repository

import android.util.Log
import com.shahad.app.shoppingapp.data.remote.response.BaseResponse
import retrofit2.Response


interface BaseRepository {

    suspend fun <T> tryTo(
        request: suspend () -> Response<BaseResponse<T>>,
    ): T? {
        return try {
            val result = request()
            Log.i("SHOPPING_APP",result.message())

            if(result.isSuccessful){
                result.body()?.data
            }else {
                null
            }
        }catch (e: Exception){
            Log.i("SHOPPING_APP",e.message.toString())
            null
        }
    }
}
