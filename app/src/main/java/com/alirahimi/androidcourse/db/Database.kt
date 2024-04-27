package com.alirahimi.androidcourse.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alirahimi.androidcourse.data.model.UserEntity
import com.alirahimi.androidcourse.db.dao.UserDao

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}

//TODO any changes in your database needs to update version code
