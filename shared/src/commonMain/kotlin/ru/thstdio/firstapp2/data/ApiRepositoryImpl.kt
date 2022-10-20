package ru.thstdio.firstapp2.data

import ru.thstdio.firstapp2.domain.model.UserInfo
import ru.thstdio.firstapp2.domain.repository.ApiRepository

class ApiRepositoryImpl : ApiRepository {
    private val service = RandomUserApiClient()
    override suspend fun getUsers(): List<UserInfo> {
        return service.getUsers().results.map { unit ->
            UserInfo(
                nick = unit.login.username,
                name = with(unit.name) { "$first $last" },
                age = unit.dob.age,
                icon = unit.picture.thumbnail
            )
        }
    }
}