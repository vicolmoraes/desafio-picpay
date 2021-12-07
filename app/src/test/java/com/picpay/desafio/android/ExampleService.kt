package com.picpay.desafio.android

import com.picpay.desafio.android.data.PicPayService
import com.picpay.desafio.android.data.User

class ExampleService(
    private val service: PicPayService
) {

    suspend fun example(): List<User> {
        val users = service.getUsers()

        return users?: emptyList()
    }
}