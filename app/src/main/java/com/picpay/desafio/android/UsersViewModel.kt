package com.picpay.desafio.android

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import java.lang.Exception

class UsersViewModel(private val repository: UserRepository) : BaseAcViewModel()  {

    val actionState = MutableLiveData<ResponseState>()

    sealed class ResponseState {
        data class getUsersSucess(val response: List<User>) : ResponseState()
        data class getUsersError(val error: Exception) : ResponseState()
    }

    fun getUsers() {
        launch {
            try {
                val response: List<User> = repository.fetchUsers()
                actionState.postValue(ResponseState.getUsersSucess(response))
            } catch (e: Exception) {
                actionState.postValue(ResponseState.getUsersError(e))
            }
        }
    }
}