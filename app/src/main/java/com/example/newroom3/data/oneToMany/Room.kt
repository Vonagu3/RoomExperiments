package com.example.newroom3.data.oneToMany

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Apartment::class,
            parentColumns = ["id"],
            childColumns = ["apartmentId"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class Room(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "roomName")
    val name: String,
    val apartmentId: Int
)
