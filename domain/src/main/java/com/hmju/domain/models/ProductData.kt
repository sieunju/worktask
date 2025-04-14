package com.hmju.domain.models

data class ProductData(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val discountPrice: Int? = null,
    val discountRate: Int,
    val isSoldOut: Boolean
) {
    val isDiscount = discountRate > 0
}
