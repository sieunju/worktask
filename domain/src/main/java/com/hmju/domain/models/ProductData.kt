package com.hmju.domain.models

data class ProductData(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val discountPrice: Int? = null,
    val discountRate: Int,
    val isSoldOut: Boolean
) {
    val isDiscount get() = discountRate > 0
}
