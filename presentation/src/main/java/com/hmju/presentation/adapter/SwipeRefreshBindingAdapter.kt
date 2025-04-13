package com.hmju.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import timber.log.Timber

object SwipeRefreshBindingAdapter {

    interface SwipeRefreshListener {
        fun callback()
    }

    @JvmStatic
    @BindingAdapter("onRefresh")
    fun setSwipeRefreshListener(
        v: SwipeRefreshLayout,
        listener: SwipeRefreshListener?
    ) {
        v.setDistanceToTriggerSync(500)
        v.setOnRefreshListener {
            runCatching {
                listener?.callback()
            }

            v.postDelayed({
                v.isRefreshing = false
            }, 500)
        }
    }

}