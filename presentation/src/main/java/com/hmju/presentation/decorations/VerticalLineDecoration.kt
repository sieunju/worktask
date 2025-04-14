package com.hmju.presentation.decorations

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.R

/**
 * Description : RecyclerView ItemDecoration
 * @param visibleViewTypes Line 을 표시할 ViewHolder ViewType들
 * Created by juhongmin on 2025. 4. 14.
 */
class VerticalLineDecoration(
    context: Context,
    private val visibleViewTypes: Set<Int>
) : RecyclerView.ItemDecoration() {

    private val divider: Drawable? by lazy {
        ContextCompat.getDrawable(context, R.drawable.vertical_line_divider)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return
        val viewType = parent.adapter?.getItemViewType(position) ?: return

        if (visibleViewTypes.contains(viewType) && position > 0) {
            outRect.top = divider?.intrinsicHeight ?: 0
        } else {
            outRect.setEmpty()
        }
    }

    override fun onDraw(
        canvas: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            if (position == RecyclerView.NO_POSITION) continue
            val viewType = parent.adapter?.getItemViewType(position) ?: continue

            if (visibleViewTypes.contains(viewType) && position > 0) {
                val params = child.layoutParams as RecyclerView.LayoutParams
                val top = child.top + params.bottomMargin
                val bottom = top + (divider?.intrinsicHeight ?: 0)
                divider?.let {
                    it.setBounds(left, top, right, bottom)
                    it.draw(canvas)
                }
            }
        }
    }
}