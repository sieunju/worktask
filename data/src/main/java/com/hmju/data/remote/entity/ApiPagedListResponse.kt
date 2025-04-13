package com.hmju.data.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiPagedListResponse<T>(
    @SerialName("data")
    val list: List<T> = listOf(),
    @SerialName("paging")
    val meta: PagingMetaEntity? = null
)