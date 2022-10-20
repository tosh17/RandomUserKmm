package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)