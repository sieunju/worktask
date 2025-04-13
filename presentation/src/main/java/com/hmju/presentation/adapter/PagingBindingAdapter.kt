package com.hmju.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.models.PagingModel

object PagingBindingAdapter {

    interface PagingListener {
        fun callback()
    }

    @JvmStatic
    @BindingAdapter(value = ["pagingModel", "onLoadNextPage"], requireAll = false)
    fun setPagingListener(
        rv: RecyclerView,
        model: PagingModel,
        callback: PagingListener?
    ) {
        if (callback == null) return

        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (model.isLast || model.isLoading || recyclerView.adapter == null) {
                    return
                } else {
                    val itemCount = recyclerView.adapter?.itemCount ?: 0
                    var pos = 0
                    when (val lm = recyclerView.layoutManager) {
                        is LinearLayoutManager -> pos = lm.findLastVisibleItemPosition()
                    }
                    val updatePosition = itemCount - pos / 2
                    if (pos >= updatePosition) {
                        callback.callback()
                    }
                }
            }
        })
    }
}
