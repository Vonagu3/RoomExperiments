package com.example.newroom3.data.manyToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Instructor(
    @PrimaryKey
    var instructorId: Int,
    var name: String
)

