package com.hmju.presentation.viewholders

import android.view.ViewGroup
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhVerticalLoadingBinding
import com.hmju.presentation.models.VerticalLoadingUiModel

class VerticalLoadingViewHolder(
    parent: ViewGroup
) : BaseViewHolder<VhVerticalLoadingBinding>(
    parent,
    R.layout.vh_vertical_loading
) {
    override fun onBindView(model: Any) {
        if (model !is VerticalLoadingUiModel) return
        binding.model = model
    }
}