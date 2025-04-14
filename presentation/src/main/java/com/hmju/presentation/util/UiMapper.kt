package com.hmju.presentation.util

import com.hmju.domain.enums.ProductViewType
import com.hmju.domain.models.SectionWithProductData
import com.hmju.presentation.models.BaseUiModel
import com.hmju.presentation.models.ProductVerticalUiModel
import com.hmju.presentation.models.SectionGridUiModel
import com.hmju.presentation.models.SectionHorizontalUiModel
import com.hmju.presentation.models.SectionTitleUiModel

object UiMapper {

    fun SectionWithProductData.toUiModels(): List<BaseUiModel> {
        val uiList = mutableListOf<BaseUiModel>()
        when (productType) {
            ProductViewType.VERTICAL -> {
                uiList.add(SectionTitleUiModel(this))
                uiList.addAll(list.map { ProductVerticalUiModel(it) })
            }

            ProductViewType.HORIZONTAL -> {
                uiList.add(SectionTitleUiModel(this))
                uiList.add(SectionHorizontalUiModel(this))
            }

            ProductViewType.GRID -> {
                uiList.add(SectionTitleUiModel(this))
                uiList.add(SectionGridUiModel(this))
            }
        }
        return uiList
    }
}
