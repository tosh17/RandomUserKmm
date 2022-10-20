package ru.thstdio.firstapp2

import ru.thstdio.firstapp2.data.ApiRepositoryImpl
import ru.thstdio.firstapp2.domain.repository.ApiRepository

class ShareComponent {
     val repository : ApiRepository = ApiRepositoryImpl()
     val title : String = "Title for ShareComponent"
}