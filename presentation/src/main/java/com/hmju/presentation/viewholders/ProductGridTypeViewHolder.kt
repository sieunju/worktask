package com.hmju.presentation.viewholders

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhProductGridTypeBinding
import com.hmju.presentation.models.ProductGridUiModel
import timber.log.Timber

/**
 * Description : 상품 > Grid Type ViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class ProductGridTypeViewHolder(
    parent: ViewGroup,
    reqManager: RequestManager? = null,
    viewModel: ViewModel? = null
) : BaseViewHolder<VhProductGridTypeBinding>(
    parent,
    R.layout.vh_product_grid_type
) {

    init {
        binding.reqManager = reqManager ?: Glide.with(itemView)
        binding.ivLike.setOnClickListener {
            Timber.d("LikeClick!!")
        }
    }

    override fun onBindView(model: Any) {
        if (model !is ProductGridUiModel) return
        binding.model = model
    }
}