package com.hmju.presentation.util

import com.hmju.domain.enums.ProductViewType
import com.hmju.domain.models.SectionWithProductData
import com.hmju.presentation.models.BaseUiModel
import com.hmju.presentation.models.SectionGridUiModel
import com.hmju.presentation.models.SectionHorizontalUiModel
import com.hmju.presentation.models.SectionVerticalUiModel

object UiMapper {

    fun SectionWithProductData.toUi(): BaseUiModel {
        return when (productType) {
            ProductViewType.VERTICAL -> SectionVerticalUiModel(this)
            ProductViewType.HORIZONTAL -> SectionHorizontalUiModel(this)
            ProductViewType.GRID -> SectionGridUiModel(this)
        }
    }
}
