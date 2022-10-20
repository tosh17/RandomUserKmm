package ru.thstdio.firstapp2.android.presentation.list

import ru.thstdio.firstapp2.domain.model.UserInfo

sealed class UserListScreenState {
    object Loading : UserListScreenState()
    data class SuccessLoad(val users: List<UserInfo>) : UserListScreenState()
}