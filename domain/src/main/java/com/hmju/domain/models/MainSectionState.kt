package com.hmju.domain.models

/**
 * Description : 메인화면 Ui State Class
 *
 * Created by juhongmin on 2025. 4. 13.
 */
sealed interface MainSectionState {
    data object Loading : MainSectionState

    data class Content(
        val list: List<SectionWithProductData> = listOf(),
        val hasNextPage: Boolean = true
    ) : MainSectionState

    data class Error(val message: String) : MainSectionState
}