package com.hmju.presentation.viewholders

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSectionVerticalTypeBinding
import com.hmju.presentation.models.SectionVerticalUiModel

/**
 * Description : 세션 Vertical ViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class SectionVerticalTypeViewHolder(
    parent: ViewGroup,
    reqManager: RequestManager? = null,
    viewModel: ViewModel? = null
) : BaseViewHolder<VhSectionVerticalTypeBinding>(
    parent,
    R.layout.vh_section_vertical_type
) {
    init {
        binding.reqManager = reqManager ?: Glide.with(itemView)
    }

    override fun onBindView(model: Any) {
        if (model !is SectionVerticalUiModel) return
        binding.model = model
    }
}