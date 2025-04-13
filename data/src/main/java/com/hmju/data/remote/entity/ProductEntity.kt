package com.hmju.data.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProductEntity(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("image")
    val image: String = "",
    @SerialName("originalPrice")
    val price: Int = 0,
    @SerialName("discountedPrice")
    val discountedPrice: Int? = null,
    @SerialName("isSoldOut")
    val isSoldOut: Boolean = false
)
