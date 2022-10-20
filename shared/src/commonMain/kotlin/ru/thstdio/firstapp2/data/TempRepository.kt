package ru.thstdio.firstapp2.data

import ru.thstdio.firstapp2.domain.dto.UserDto
import ru.thstdio.firstapp2.domain.model.UserInfo
import ru.thstdio.firstapp2.domain.repository.ApiRepository

class TempRepository : ApiRepository {
    override suspend fun getUsers(): List<UserInfo> {
        TODO("Not yet implemented")
    }

}