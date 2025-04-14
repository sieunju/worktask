package com.hmju.presentation.models

import com.hmju.presentation.R

data class VerticalLoadingUiModel(
    val uid: Long = System.currentTimeMillis()
) : BaseUiModel(R.layout.vh_vertical_loading)