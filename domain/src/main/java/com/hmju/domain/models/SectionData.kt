package com.hmju.domain.models

import com.hmju.domain.enums.ProductViewType

data class SectionData(
    val title: String,
    val id: Long,
    val productType: ProductViewType
)
