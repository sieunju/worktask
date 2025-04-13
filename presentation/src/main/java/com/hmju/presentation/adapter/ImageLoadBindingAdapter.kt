package com.hmju.presentation.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

object ImageLoadBindingAdapter {

    private val crossFadeFactory: DrawableCrossFadeFactory by lazy {
        DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
    }

    private val crossFadeTransition: DrawableTransitionOptions by lazy {
        DrawableTransitionOptions.withCrossFade(crossFadeFactory)
    }

    @JvmStatic
    @BindingAdapter(
        value = ["reqManager", "imageUrl"],
        requireAll = false
    )
    fun bindImageLoad(
        iv: AppCompatImageView,
        reqManager: RequestManager?,
        imageUrl: String? = null
    ) {
        if (imageUrl.isNullOrEmpty()) {
            iv.visibility = View.INVISIBLE
            return
        }
        if (reqManager == null) return
        reqManager
            .load(imageUrl)
            .transition(crossFadeTransition)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(iv)
    }
}