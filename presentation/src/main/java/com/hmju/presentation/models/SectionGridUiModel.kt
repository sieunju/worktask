package com.hmju.presentation.models

import com.hmju.domain.models.SectionWithProductData
import com.hmju.presentation.R

/**
 * Description : 세션 > Grid 타입 UiModel
 *
 * Created by juhongmin on 2025. 4. 13.
 */
data class SectionGridUiModel(
    val id: Int,
    val uiList: List<BaseUiModel>
) : BaseUiModel(R.layout.vh_section_grid_type) {

    constructor(
        data: SectionWithProductData
    ) : this(
        id = data.id,
        uiList = data.list.map { ProductGridUiModel(it) }
    )
}