package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class Id(
    val name: String,
    val value: String?
)