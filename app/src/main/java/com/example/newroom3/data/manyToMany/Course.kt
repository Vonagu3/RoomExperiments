package com.example.newroom3.data.manyToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey
    var courseId: Int,
    var name: String
)