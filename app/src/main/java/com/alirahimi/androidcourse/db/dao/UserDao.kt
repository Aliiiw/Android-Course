package com.alirahimi.androidcourse.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alirahimi.androidcourse.data.Constants
import com.alirahimi.androidcourse.data.model.UserEntity


//TODO my queries


@Dao
interface UserDao {

    //TODO 1. say the type of query / and the manager
    //TODO 2. say the function name
    //TODO 3. say the function return type

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Query("SELECT * FROM ${Constants.USER_TABLE}")
    fun getAllUsers(): MutableList<UserEntity>

    @Query("SELECT * FROM ${Constants.USER_TABLE} WHERE userID=:userID")
    fun getUser(userID: Int): UserEntity

    @Query("DELETE FROM ${Constants.USER_TABLE}")
    fun deleteAllUsers()


}