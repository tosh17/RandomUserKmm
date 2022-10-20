package ru.thstdio.firstapp2.android.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.thstdio.firstapp2.ShareComponent


class UserListViewModel : ViewModel() {
    private val shareComponent = ShareComponent()
    private val _state: MutableStateFlow<UserListScreenState> =
        MutableStateFlow(UserListScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.emit(UserListScreenState.Loading)
            val users = shareComponent.repository.getUsers()
            _state.emit(UserListScreenState.SuccessLoad(users))
        }
    }
}