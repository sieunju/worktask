package com.hmju.domain.models

data class SectionResponse(
    val list : List<SectionData> = listOf(),
    val hasNextPage: Boolean
)
