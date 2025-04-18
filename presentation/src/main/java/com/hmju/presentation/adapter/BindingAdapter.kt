package com.hmju.presentation.adapter

import android.graphics.Paint
import android.graphics.Typeface
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.hmju.domain.shared.LikeManager
import com.hmju.presentation.R
import com.hmju.presentation.models.BaseUiModel

/**
 * Description : DataBinding Adapter
 *
 * Created by juhongmin on 2025. 4. 13.
 */
object BindingAdapter {


    @JvmStatic
    @BindingAdapter(
        value = ["reqManager", "viewModel", "dataList"],
        requireAll = false
    )
    fun setItemListAdapter(
        rv: RecyclerView,
        reqManager: RequestManager? = null,
        viewModel: ViewModel? = null,
        dataList: List<BaseUiModel>? = null
    ) {
        if (rv.adapter == null) {
            rv.adapter = ItemListAdapter()
        }

        (rv.adapter as ItemListAdapter).apply {
            setReqManager(reqManager)
            setViewModel(viewModel)
            submitList(dataList)
        }
    }

    @JvmStatic
    @BindingAdapter(
        value = ["price", "discountPrice"],
        requireAll = false
    )
    fun bindOriginPrice(
        tv: AppCompatTextView,
        price: Int? = null,
        discountPrice: Int? = null
    ) {
        if (price == null) return
        // 할인중 - 취소선
        if (discountPrice != null && price > discountPrice) {
            tv.paintFlags = tv.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            tv.setTypeface(null, Typeface.NORMAL)
            tv.setTextColor(ContextCompat.getColor(tv.context, R.color.grey))
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        } else {
            tv.paintFlags = tv.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            tv.setTypeface(null, Typeface.BOLD)
            tv.setTextColor(ContextCompat.getColor(tv.context, R.color.black))
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        }
    }

    @JvmStatic
    @BindingAdapter("isLikeProduct")
    fun bindLikeProduct(
        iv: AppCompatImageView,
        id: Int? = null
    ) {
        if (id == null) {
            iv.isSelected = false
            return
        }
        iv.isSelected = LikeManager.isLike(id)
    }
}