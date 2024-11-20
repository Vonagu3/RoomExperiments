package com.example.newroom3.data.oneToManyRelation

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithApartments(
    @Embedded val user: User2,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val apartments: List<Apartment2>
)