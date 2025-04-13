package com.hmju.presentation.viewholders

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhProductHorizontalTypeBinding
import com.hmju.presentation.models.ProductHorizontalUiModel
import timber.log.Timber

/**
 * Description : 상품 > Horizontal Type ViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class ProductHorizontalTypeViewHolder(
    parent: ViewGroup,
    reqManager: RequestManager? = null,
    viewModel: ViewModel? = null
) : BaseViewHolder<VhProductHorizontalTypeBinding>(
    parent,
    R.layout.vh_product_horizontal_type
) {

    init {
        binding.reqManager = reqManager ?: Glide.with(itemView)
        binding.ivLike.setOnClickListener {
            Timber.d("LikeClick!!")
        }
    }

    override fun onBindView(model: Any) {
        if (model !is ProductHorizontalUiModel) return
        binding.model = model
    }
}