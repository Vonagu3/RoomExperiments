package com.example.newroom3.data.oneToManyRelation

import androidx.room.Embedded
import androidx.room.Relation

data class UsersWithApartmentsAndRooms(
    @Embedded val user: User2,
    @Relation(
        entity = Apartment2::class,
        parentColumn = "id",
        entityColumn = "userId"
    )
    val apartmentsWithRooms: List<ApartmentWithRooms>
//    @Relation(
//        parentColumn = "id",
//        entityColumn = "userId"
//    )
//    val apartments: List<Apartment2>,
//
//    @Relation(
//        parentColumn = "id",
//        entityColumn = "apartmentId"
//    )
//    val rooms: List<Room2>
)
