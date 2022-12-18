package com.shahad.app.shoppingapp.data.remote

import com.shahad.app.shoppingapp.data.remote.response.BaseResponse
import com.shahad.app.shoppingapp.data.remote.response.CategoryDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingService{

    @GET("/getSaleCategory")
    suspend fun getSaleCategory(
        @Query("limit") limit: Int
    ): Response<BaseResponse<CategoryDTO>>

    @GET("/getNewCategory")
    suspend fun getNewCategory(
        @Query("limit") limit: Int
    ): Response<BaseResponse<CategoryDTO>>

    @GET("/getShoesCategory")
    suspend fun getShoesCategory(
        @Query("limit") limit: Int
    ): Response<BaseResponse<CategoryDTO>>

    @GET("/getClothesCategory")
    suspend fun getClothesCategory(
        @Query("limit") limit: Int
    ): Response<BaseResponse<CategoryDTO>>

    @GET("/getAccessoriesCategory")
    suspend fun getAccessoriesCategory(
        @Query("limit") limit: Int
    ): Response<BaseResponse<CategoryDTO>>

}