package com.picpay.desafio.android.presentation

import UserDao
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.data.User
import com.picpay.desafio.android.data.UserRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class UsersViewModel(private val repository: UserRepository, private val dao: UserDao) :
    BaseAcViewModel() {

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