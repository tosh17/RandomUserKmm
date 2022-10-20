package ru.thstdio.firstapp2.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import ru.thstdio.firstapp2.domain.dto.RandomUsersListResponse



class RandomUserApiClient {
    companion object {
        private const val BASE_URL = "https://randomuser.me/api/"
    }

    private val httpApiClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun getUsers(): RandomUsersListResponse {
        return httpApiClient.get(BASE_URL+"?results=5000") {
        }
            .body()
    }

//    suspend fun getUserInfo(): List<UserInfoDto> {
//        return httpApiClient.get(URL)
//    }
}