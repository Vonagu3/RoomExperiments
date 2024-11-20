package com.example.newroom3.data.oneToManyRelation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.newroom3.data.oneToMany.Apartment
import com.example.newroom3.data.oneToMany.Room

data class ApartmentWithRooms(
    @Embedded val apartment: Apartment2,

    @Relation(
        entity = Room2::class,
        parentColumn = "id",
        entityColumn = "apartmentId"
    )
    val rooms: List<Room2>
)
