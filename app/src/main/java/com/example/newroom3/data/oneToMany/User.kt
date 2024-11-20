package com.example.newroom3.data.oneToMany

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @PrimaryKey(autoGenerate = false)
//    @ColumnInfo(name = "user_id")
    val id: Int = 0,
    @ColumnInfo(name = "userName")
    val name: String,
//    @ColumnInfo(defaultValue = "18")
    val age: Int? = null,
//    @ColumnInfo(defaultValue = "0")
    val height: Int? = null
)