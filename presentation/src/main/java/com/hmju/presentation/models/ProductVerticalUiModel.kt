package com.hmju.presentation.models

import com.hmju.domain.models.ProductData
import com.hmju.presentation.R

/**
 * Description : 상품 > Vertical Type UiModel
 *
 * Created by juhongmin on 2025. 4. 13.
 */
data class ProductVerticalUiModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val discountRate: Int,
    val discountPrice: Int? = null,
    val isSoldOut: Boolean,
    val isDiscount: Boolean
) : BaseUiModel(R.layout.vh_product_vertical_type) {

    constructor(
        data: ProductData
    ) : this(
        id = data.id,
        name = data.name,
        imageUrl = data.imageUrl,
        price = data.price,
        discountRate = data.discountRate,
        discountPrice = data.discountPrice,
        isSoldOut = data.isSoldOut,
        isDiscount = data.isDiscount
    )
}
