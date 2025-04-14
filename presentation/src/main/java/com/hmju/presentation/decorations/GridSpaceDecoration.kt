package com.hmju.presentation.decorations

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Description : Grid 형태의 RecyclerView.ItemDecoration
 *
 * Created by juhongmin on 2025. 4. 15.
 */
class GridSpaceDecoration(
    context: Context,
    private val spanCount: Int,
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
        val position: Int = parent.getChildAdapterPosition(view)

        if (position >= 0) {
            val column = position % spanCount
            outRect.apply {
                left = spaceDp - column * spaceDp / spanCount
                right = (column + 1) * spaceDp / spanCount
                if (position < spanCount) top = spaceDp
                bottom = spaceDp
            }
        } else {
            outRect.setEmpty()
        }
    }
}