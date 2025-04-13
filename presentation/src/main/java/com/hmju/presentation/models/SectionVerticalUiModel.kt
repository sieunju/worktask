package com.hmju.presentation.models

import com.hmju.domain.models.SectionWithProductData
import com.hmju.presentation.R

/**
 * Description : 세션 > 수직 타입 UiModel
 *
 * Created by juhongmin on 2025. 4. 13.
 */
data class SectionVerticalUiModel(
    val id: Int,
    val title: String,
    val uiList: List<BaseUiModel>
) : BaseUiModel(R.layout.vh_section_vertical_type) {

    constructor(
        data: SectionWithProductData
    ) : this(
        id = data.id,
        title = data.title,
        uiList = data.list.map { ProductVerticalUiModel(it) }
    )
}
