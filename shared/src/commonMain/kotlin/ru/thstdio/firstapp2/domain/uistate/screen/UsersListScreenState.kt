package ru.thstdio.firstapp2.domain.uistate.screen

import ru.thstdio.firstapp2.domain.uistate.view.UserItemViewState

sealed class UsersListScreenState {
    object SkeletonLoading : UsersListScreenState()
    data class UsersList(val list: List<UserItemViewState>)
    object NotAvailableService : UsersListScreenState()
}
