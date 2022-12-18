package com.shahad.app.shoppingapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class ProductDTO(
    @SerializedName("brandName")
    val brandName: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("discount")
    val discount: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageUrl")
    val imageUrl: String? = null,
    @SerializedName("isDiscount")
    val isDiscount: Boolean? = null,
    @SerializedName("isNew")
    val isNew: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("rating")
    val rating: Double? = null
)