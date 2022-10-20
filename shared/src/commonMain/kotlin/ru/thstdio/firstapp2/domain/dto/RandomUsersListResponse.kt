package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomUsersListResponse(
    val info: Info,
    val results: List<UserDto>
)