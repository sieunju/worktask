package com.hmju.domain.models

import com.hmju.domain.enums.ProductViewType

/**
 * Description : 세션 With 상품 리스트 데이터 모델
 *
 * Created by juhongmin on 2025. 4. 13.
 */
data class SectionWithProductData(
    val id: Int,
    val title: String,
    val productType: ProductViewType,
    val list: List<ProductData> = listOf()
) {
    constructor(
        section: SectionData,
        list: List<ProductData>
    ) : this(
        id = section.id,
        title = section.title,
        productType = section.productType,
        list = list
    )
}
