package com.shahad.app.shoppingapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("statusCode")
    val statusCode: Int? = null
)