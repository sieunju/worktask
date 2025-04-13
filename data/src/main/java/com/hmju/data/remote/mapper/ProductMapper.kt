package com.hmju.data.remote.mapper

import com.hmju.data.remote.entity.ProductEntity
import com.hmju.domain.models.ProductData
import kotlin.math.roundToInt

/**
 * Description : Entity -> Data Model Mapper
 *
 * Created by juhongmin on 2025. 4. 13.
 */
internal object ProductMapper {

    private fun calculateDiscountRate(price: Int, discountPrice: Int): Int {
        val amount = price - discountPrice
        val rate = (amount.toFloat() / price.toFloat()) * 100
        return rate.roundToInt()
    }

    fun ProductEntity.toMap(): ProductData {
        return ProductData(
            id = id,
            name = name,
            imageUrl = image,
            price = price,
            discountPrice = discountedPrice,
            discountRate = discountedPrice?.let { calculateDiscountRate(price, it) } ?: 0,
            isSoldOut = isSoldOut
        )
    }
}