package com.picpay.desafio.android.data

import UserDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { appDatabase ->
                    instance = appDatabase
                }
            }

        private fun buildDatabase(appContext: Context): AppDatabase {
            return Room.databaseBuilder(appContext, AppDatabase::class.java, "Db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
