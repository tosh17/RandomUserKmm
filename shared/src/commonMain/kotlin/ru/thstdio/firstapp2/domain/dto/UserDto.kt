package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: NameDto,
    val nat: String,
    val phone: String,
    val picture: PictureDto,
    val registered: Registered
)