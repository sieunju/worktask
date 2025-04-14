package com.hmju.presentation.viewholders

import android.view.ViewGroup
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSectionTitleTypeBinding
import com.hmju.presentation.models.SectionTitleUiModel

/**
 * Description : 섹션 > 제목 ViewHolder
 *
 * Created by juhongmin on 2025. 4. 14.
 */
class MainSectionTitleViewHolder(
    parent: ViewGroup
) : BaseViewHolder<VhSectionTitleTypeBinding>(
    parent,
    R.layout.vh_section_title_type
) {
    
    override fun onBindView(model: Any) {
        if (model !is SectionTitleUiModel) return
        binding.model = model
    }
}
