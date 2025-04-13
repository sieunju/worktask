package com.hmju.presentation.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Description : BaseViewHolder
 *
 * Created by juhongmin on 2025. 4. 13.
 */
abstract class BaseViewHolder<T : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {

    val binding: T by lazy { DataBindingUtil.bind(itemView)!! }

    abstract fun onBindView(model: Any)
}
