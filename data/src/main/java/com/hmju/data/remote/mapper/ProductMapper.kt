package com.hmju.data.remote.mapper

import com.hmju.data.remote.entity.ProductEntity
import com.hmju.domain.models.ProductData

/**
 * Description : Entity -> Data Model Mapper
 *
 * Created by juhongmin on 2025. 4. 13.
 */
internal object ProductMapper {

    fun ProductEntity.toMap(): ProductData {
        return ProductData(
            id = id,
            name = name,
            imageUrl = image,
            price = price,
            discountPrice = discountedPrice,
            isSoldOut = isSoldOut,
            isDiscount = discountedPrice != null
        )
    }
}