package com.hmju.data.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SectionEntity(
    @SerialName("title")
    val title: String = "",
    @SerialName("id")
    val id: Long = 0,
    @SerialName("type")
    val type: String = "",
    @SerialName("url")
    val url: String = ""
)