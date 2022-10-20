package ru.thstdio.firstapp2.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)