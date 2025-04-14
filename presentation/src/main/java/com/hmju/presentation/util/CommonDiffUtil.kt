package com.hmju.presentation.util

import androidx.recyclerview.widget.DiffUtil
import com.hmju.presentation.models.BaseUiModel
import com.hmju.presentation.models.ProductGridUiModel
import com.hmju.presentation.models.ProductHorizontalUiModel
import com.hmju.presentation.models.ProductVerticalUiModel
import com.hmju.presentation.models.SectionGridUiModel
import com.hmju.presentation.models.SectionHorizontalUiModel
import com.hmju.presentation.models.SectionTitleUiModel
import com.hmju.presentation.models.VerticalLoadingUiModel

/**
 * Description : RecyclerView DiffUtilClass
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class CommonDiffUtil : DiffUtil.ItemCallback<BaseUiModel>() {

    override fun areItemsTheSame(
        oldItem: BaseUiModel,
        newItem: BaseUiModel
    ): Boolean {
        return if (oldItem is ProductHorizontalUiModel &&
            newItem is ProductHorizontalUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is ProductVerticalUiModel &&
            newItem is ProductVerticalUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is ProductGridUiModel &&
            newItem is ProductGridUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is SectionHorizontalUiModel &&
            newItem is SectionHorizontalUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is SectionGridUiModel &&
            newItem is SectionGridUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is SectionTitleUiModel &&
            newItem is SectionTitleUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is VerticalLoadingUiModel &&
            newItem is VerticalLoadingUiModel
        ) {
            oldItem.uid == newItem.uid
        } else {
            false
        }
    }

    override fun areContentsTheSame(
        oldItem: BaseUiModel,
        newItem: BaseUiModel
    ): Boolean {
        return if (oldItem is ProductHorizontalUiModel &&
            newItem is ProductHorizontalUiModel
        ) {
            oldItem == newItem
        } else if (oldItem is ProductVerticalUiModel &&
            newItem is ProductVerticalUiModel
        ) {
            oldItem == newItem
        } else if (oldItem is ProductGridUiModel &&
            newItem is ProductGridUiModel
        ) {
            oldItem == newItem
        } else if (oldItem is SectionHorizontalUiModel &&
            newItem is SectionHorizontalUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is SectionGridUiModel &&
            newItem is SectionGridUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is SectionTitleUiModel &&
            newItem is SectionTitleUiModel
        ) {
            oldItem.id == newItem.id
        } else if (oldItem is VerticalLoadingUiModel &&
            newItem is VerticalLoadingUiModel
        ) {
            oldItem.uid == newItem.uid
        } else {
            false
        }
    }
}