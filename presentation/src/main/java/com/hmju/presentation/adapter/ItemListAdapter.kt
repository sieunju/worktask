package com.hmju.presentation.adapter

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.hmju.presentation.R
import com.hmju.presentation.models.BaseUiModel
import com.hmju.presentation.util.CommonDiffUtil
import com.hmju.presentation.viewholders.BaseViewHolder
import com.hmju.presentation.viewholders.ProductGridTypeViewHolder
import com.hmju.presentation.viewholders.ProductHorizontalTypeViewHolder
import com.hmju.presentation.viewholders.ProductVerticalTypeViewHolder
import com.hmju.presentation.viewholders.SectionGridTypeViewHolder
import com.hmju.presentation.viewholders.SectionHorizontalTypeViewHolder
import com.hmju.presentation.viewholders.SectionVerticalTypeViewHolder

/**
 * Description : 공통 ItemListAdapter
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class ItemListAdapter : ListAdapter<BaseUiModel, BaseViewHolder<*>>(
    CommonDiffUtil()
) {
    private var reqManager: RequestManager? = null
    private var viewModel: ViewModel? = null

    fun setReqManager(reqManager: RequestManager?) {
        this.reqManager = reqManager
    }

    fun setViewModel(viewModel: ViewModel?) {
        this.viewModel = viewModel
    }

    override fun submitList(list: List<BaseUiModel>?) {
        val newList = list?.toMutableList()
        super.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            R.layout.vh_product_horizontal_type -> ProductHorizontalTypeViewHolder(
                parent,
                reqManager,
                viewModel
            )

            R.layout.vh_product_vertical_type -> ProductVerticalTypeViewHolder(
                parent,
                reqManager,
                viewModel
            )

            R.layout.vh_product_grid_type -> ProductGridTypeViewHolder(
                parent,
                reqManager,
                viewModel
            )

            R.layout.vh_section_horizontal_type -> SectionHorizontalTypeViewHolder(
                parent,
                reqManager,
                viewModel
            )

            R.layout.vh_section_grid_type -> SectionGridTypeViewHolder(
                parent,
                reqManager,
                viewModel
            )

            R.layout.vh_section_vertical_type -> SectionVerticalTypeViewHolder(
                parent,
                reqManager,
                viewModel
            )

            else -> throw IllegalArgumentException("Invalid ViewType:${viewType}")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.onBindView(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }
}