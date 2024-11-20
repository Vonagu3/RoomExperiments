package com.example.newroom3.data.oneToManyRelation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User2(
    @PrimaryKey
//    @ColumnInfo(name = "userId")
    val id: Int,
    val name: String
)