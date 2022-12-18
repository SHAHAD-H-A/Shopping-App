package com.shahad.app.shoppingapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class CategoryDTO(
    @SerializedName("content")
    val content: List<ProductDTO>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null
)