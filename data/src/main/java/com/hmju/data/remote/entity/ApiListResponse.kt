package com.hmju.data.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiListResponse<T>(
    @SerialName("data")
    val list: List<T> = listOf()
)
