package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class NameDto(
    val first: String,
    val last: String,
    val title: String
)