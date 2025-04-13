package com.hmju.presentation.models

/**
 * Description : 페이징 관련 데이터 모델
 *
 * Created by juhongmin on 2025. 4. 13.
 */
data class PagingModel(
    var isLoading: Boolean = true,
    var isLast: Boolean = false
) {
    fun initParams() {
        isLoading = true
        isLast = false
    }
}
