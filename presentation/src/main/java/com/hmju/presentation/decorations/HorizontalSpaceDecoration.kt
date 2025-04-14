package com.hmju.presentation.decorations

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Description : 수평 간격 RecyclerView.ItemDecoration
 *
 * Created by juhongmin on 2025. 4. 14.
 */
class HorizontalSpaceDecoration(
    context: Context,
    private val space: Int
) : RecyclerView.ItemDecoration() {

    private val spaceDp: Int by lazy {
        (space * context.resources.displayMetrics.density).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0
        if (position < itemCount - 1) {
            outRect.right = spaceDp
        } else {
            outRect.right = 0
        }
    }
}
