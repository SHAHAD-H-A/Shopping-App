package com.shahad.app.shoppingapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class FashionProductDTO(
    @SerializedName("id")
    val id: Int?= null,

    @SerializedName("name")
    val name: String?= null,

    @SerializedName("description")
    val description: String?= null,

    @SerializedName("price")
    val price: Int?= null,

    @SerializedName("colors")
    val colors: List<String>?= null,

    @SerializedName("size")
    val sizes: List<String>?= null,

    @SerializedName("images")
    val images: List<String>? = null,

    @SerializedName("material")
    val material: String? = null,

    @SerializedName("care")
    val care: String?= null,

    @SerializedName("category")
    var category: String?=null,

    @SerializedName("group")
    val group: String? = null,
)
