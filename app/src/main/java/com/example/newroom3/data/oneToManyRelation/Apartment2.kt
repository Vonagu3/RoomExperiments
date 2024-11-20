package com.example.newroom3.data.oneToManyRelation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Apartment2(
    @PrimaryKey
//    @ColumnInfo(name = "apartmentId")
    val id: Int,
    val address: String,
    val userId: Int
)