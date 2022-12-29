package com.shahad.app.shoppingapp.data.remote

import com.shahad.app.shoppingapp.data.remote.response.BaseResponse
import com.shahad.app.shoppingapp.data.remote.response.BrandDTO
import com.shahad.app.shoppingapp.data.remote.response.CategoryDTO
import com.shahad.app.shoppingapp.data.remote.response.FashionProductDTO
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

    @GET("/getBrands")
    suspend fun getBrands(): Response<BaseResponse<List<BrandDTO>>>

    @GET("/getNewArrival")
    suspend fun getNewArrival(): Response<BaseResponse<List<FashionProductDTO>>>

    @GET("/getRecommendedForYou")
    suspend fun getRecommendedForYou(): Response<BaseResponse<List<FashionProductDTO>>>

}