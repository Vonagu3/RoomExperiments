package com.example.newroom3.data.oneToMany

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class Apartment(
    @PrimaryKey(autoGenerate = false)
//    @ColumnInfo(name = "apartment_id")
    val id: Int,
    val adress: String,
    val userId: Int
)