package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class PictureDto(
    val large: String,
    val medium: String,
    val thumbnail: String
)