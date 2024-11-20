package com.example.newroom3.data.oneToManyRelation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Room2(
    @PrimaryKey
//    @ColumnInfo(name = "roomId")
    val id: Int,
    val name: String,
    val apartmentId: Int
)
