package com.picpay.desafio.android.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "img") val img: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "username") val username: String?
)