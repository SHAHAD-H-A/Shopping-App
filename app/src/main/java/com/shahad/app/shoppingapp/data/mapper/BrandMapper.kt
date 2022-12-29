package com.shahad.app.shoppingapp.data.mapper

import com.shahad.app.shoppingapp.data.remote.response.BrandDTO
import com.shahad.app.shoppingapp.domain.entity.Brand

fun BrandDTO.toBrand(): Brand{
    return Brand(
        id = this.id ?: 0,
        imageUrl =this.imageUrl ?: "",
        name =this.name ?: "UNKNOWN NAME",
        siteUrl = this.siteUrl ?: ""
    )
}