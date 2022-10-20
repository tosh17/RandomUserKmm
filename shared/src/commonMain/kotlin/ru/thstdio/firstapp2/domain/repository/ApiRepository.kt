package ru.thstdio.firstapp2.domain.repository

import ru.thstdio.firstapp2.domain.model.UserInfo

interface ApiRepository {
    suspend fun getUsers(): List<UserInfo>
}