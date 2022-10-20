package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    val age: Int,
    val date: String
)