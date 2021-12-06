package com.picpay.desafio.android

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    suspend fun fetchUsers(): List<User> = withContext(Dispatchers.IO) {
        return@withContext RetrofitConfig().service.getUsers()
    }
}