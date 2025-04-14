package com.hmju.presentation.viewholders

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSectionGridTypeBinding
import com.hmju.presentation.decorations.GridSpaceDecoration
import com.hmju.presentation.models.SectionGridUiModel

/**
 * Description : 세션 Grid ViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class SectionGridTypeViewHolder(
    parent: ViewGroup,
    reqManager: RequestManager? = null,
    viewModel: ViewModel? = null
) : BaseViewHolder<VhSectionGridTypeBinding>(
    parent,
    R.layout.vh_section_grid_type
) {

    private val decoration: RecyclerView.ItemDecoration by lazy {
        GridSpaceDecoration(parent.context, 3, 4)
    }

    init {
        binding.reqManager = reqManager ?: Glide.with(itemView)
        binding.vm = viewModel
        binding.rvContents.addItemDecoration(decoration)
    }

    override fun onBindView(model: Any) {
        if (model !is SectionGridUiModel) return
        binding.model = model
    }
}