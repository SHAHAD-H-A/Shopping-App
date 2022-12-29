package com.shahad.app.shoppingapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class BrandDTO(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageUrl")
    val imageUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("siteUrl")
    val siteUrl: String? = null
)