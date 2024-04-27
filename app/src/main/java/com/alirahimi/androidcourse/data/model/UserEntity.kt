package com.alirahimi.androidcourse.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alirahimi.androidcourse.data.Constants


@Entity(tableName = Constants.USER_TABLE)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userID: Int,
    @ColumnInfo(name = Constants.USER_TABLE_USER_NAME_COLUMN)
    val userName: String,
    val userAge: Int,
)
//TODO my entities