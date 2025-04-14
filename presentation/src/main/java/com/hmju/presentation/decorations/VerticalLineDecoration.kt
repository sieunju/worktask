package com.hmju.presentation.decorations

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.R
import timber.log.Timber

class VerticalLineDecoration(
    context: Context
) : RecyclerView.ItemDecoration() {

    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.grey)
        style = Paint.Style.STROKE
        strokeWidth = 1f
    }

    private val dividerHeight = context.resources.displayMetrics.density.toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        // 첫 번째 아이템이 아닌 경우에만 상단 여백 추가
        if (position > 0) {
            outRect.top = dividerHeight
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
            val viewType = parent.adapter?.getItemViewType(position)
            when (viewType) {
                R.layout.vh_product_horizontal_type -> {
                    Timber.d("ViewHolder-ProductHorizontalTypeViewHolder")
                }

                R.layout.vh_section_horizontal_type -> {
                    Timber.d("ViewHolder-SectionHorizontalTypeViewHolder")
                }

                R.layout.vh_section_grid_type -> {
                    Timber.d("ViewHolder-SectionGridTypeViewHolder")
                }
            }

            if (position > 0) {
                val params = child.layoutParams as RecyclerView.LayoutParams
                val top = child.top - params.topMargin - dividerHeight

                canvas.drawRect(
                    left.toFloat(),
                    top.toFloat(),
                    right.toFloat(),
                    (top + dividerHeight).toFloat(),
                    paint
                )
            }
        }
    }
}