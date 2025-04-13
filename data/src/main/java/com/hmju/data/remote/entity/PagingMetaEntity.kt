package com.hmju.data.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class PagingMetaEntity(
    @SerialName("next_page")
    val nextPage: Int = 1
)
