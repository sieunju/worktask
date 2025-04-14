package com.hmju.presentation.viewholders

import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hmju.domain.shared.LikeManager
import com.hmju.presentation.R
import com.hmju.presentation.databinding.VhProductGridTypeBinding
import com.hmju.presentation.listener.LikeListener
import com.hmju.presentation.models.ProductGridUiModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

/**
 * Description : 상품 > Grid Type ViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class ProductGridTypeViewHolder(
    parent: ViewGroup,
    reqManager: RequestManager? = null,
    private val viewModel: ViewModel? = null
) : BaseViewHolder<VhProductGridTypeBinding>(
    parent,
    R.layout.vh_product_grid_type
), LifecycleEventObserver {

    private var likeJob: Job? = null

    init {
        itemView.doOnAttach { v ->
            v.findViewTreeLifecycleOwner()?.also { owner ->
                owner.lifecycle.addObserver(this)
            }
        }

        itemView.doOnDetach { v ->
            v.findViewTreeLifecycleOwner()?.lifecycle?.removeObserver(this)
            cancelLikeJob()
        }

        binding.reqManager = reqManager ?: Glide.with(itemView)
        binding.ivLike.setOnClickListener { handleLikeEvent() }
    }

    override fun onBindView(model: Any) {
        if (model !is ProductGridUiModel) return
        binding.model = model
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_RESUME) {
            initLikeObserver(source)
        } else if (event == Lifecycle.Event.ON_PAUSE) {
            cancelLikeJob()
        }
    }

    private fun handleLikeEvent() {
        val model = binding.model ?: return
        val listener = viewModel as? LikeListener ?: return
        if (LikeManager.isLike(model.id)) {
            listener.onRemoveLike(model.id)
        } else {
            listener.onAddLike(model.id)
        }
    }

    private fun initLikeObserver(source: LifecycleOwner) {
        likeJob = source.lifecycleScope.launch {
            LikeManager.observer()
                .filter { it == binding.model?.id }
                .collect { binding.invalidateAll() }
        }
    }

    private fun cancelLikeJob() {
        likeJob?.cancel()
        likeJob = null
    }
}