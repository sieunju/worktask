package com.hmju.presentation.viewholders

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhSectionHorizontalTypeBinding
import com.hmju.presentation.decorations.HorizontalSpaceDecoration
import com.hmju.presentation.models.SectionHorizontalUiModel

/**
 * Description : 세션 Horizontal ViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class SectionHorizontalTypeViewHolder(
    parent: ViewGroup,
    reqManager: RequestManager? = null,
    viewModel: ViewModel? = null
) : BaseViewHolder<VhSectionHorizontalTypeBinding>(
    parent,
    R.layout.vh_section_horizontal_type
) {

    private val decoration: RecyclerView.ItemDecoration by lazy {
        HorizontalSpaceDecoration(parent.context, 16)
    }

    init {
        binding.reqManager = reqManager ?: Glide.with(itemView)
        binding.vm = viewModel
        binding.rvContents.addItemDecoration(decoration)
        binding.iExampleDummy.post {
            val height = binding.iExampleDummy.height
            if (height > 0) {
                binding.rvContents.minimumHeight = height
                binding.iExampleDummy.visibility = View.GONE
            }
        }
    }

    override fun onBindView(model: Any) {
        if (model !is SectionHorizontalUiModel) return
        binding.model = model
    }
}