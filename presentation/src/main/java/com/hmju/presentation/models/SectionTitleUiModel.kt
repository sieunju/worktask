package com.hmju.presentation.models

import com.hmju.domain.models.SectionWithProductData
import com.hmju.presentation.R

/**
 * Description : 섹션 제목
 *
 * Created by juhongmin on 2025. 4. 14.
 */
data class SectionTitleUiModel(
    val id: Int,
    val title: String
) : BaseUiModel(R.layout.vh_section_title_type) {

    constructor(
        data: SectionWithProductData
    ) : this(
        id = data.id,
        title = data.title
    )
}
