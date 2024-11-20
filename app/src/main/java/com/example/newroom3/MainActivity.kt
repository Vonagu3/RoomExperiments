package com.example.newroom3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.newroom3.data.oneToMany.Apartment
import com.example.newroom3.data.MainDatabase
import com.example.newroom3.data.manyToMany.Course
import com.example.newroom3.data.manyToMany.CourseWithInstructor
import com.example.newroom3.data.manyToMany.Instructor
import com.example.newroom3.data.oneToMany.Room
import com.example.newroom3.data.oneToMany.Users
import com.example.newroom3.data.oneToManyRelation.Apartment2
import com.example.newroom3.data.oneToManyRelation.Room2
import com.example.newroom3.data.oneToManyRelation.User2
import com.example.newroom3.data.oneToManyRelation.UserWithApartments
import com.example.newroom3.data.oneToManyRelation.UsersWithApartmentsAndRooms
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = MainDatabase.getInstance(this).mainDao

//        ----------------------------------------------
//        Many to Many
        val course1 = Course(1, "course1")
        val instructor1 = Instructor(1, "instructor1")
        val course2 = Course(2, "course2")
        val instructor2 = Instructor(2, "instructor2")
        val courseWithInstructor1 = CourseWithInstructor(1, 1)
        val courseWithInstructor2 = CourseWithInstructor(1, 2)
        val courseWithInstructor3 = CourseWithInstructor(2, 1)
        lifecycleScope.launch {
            dao.insertCourse(course1)
            dao.insertCourse(course2)
            dao.insertInstructor(instructor1)
            dao.insertInstructor(instructor2)
            dao.insertCourseWithInstructor(courseWithInstructor1)
            dao.insertCourseWithInstructor(courseWithInstructor2)
            dao.insertCourseWithInstructor(courseWithInstructor3)
            val res1 = dao.getInstructorsOfCourse()
            Log.d("Room", res1.toString())
            val res2 = dao.getCoursesOfInstructor()
            Log.d("Room", res2.toString())
        }


//        -----------------------------------------------
//        One to many (Relation)
//        val users = listOf(
//            User2(id = 1, name = "Test1"),
//            User2(id = 2, name = "Test2")
//        )
//
//        val apartments = listOf(
//            Apartment2(id = 1, address = "Moscow, Alexander Monahovoi", userId = 1),
//            Apartment2(id = 2, address = "Moscow, Ozernaya", userId = 1),
//            Apartment2(id = 3, address = "Moscow, Moscouski", userId = 2)
//        )
//
//        val rooms = listOf(
//            Room2(id = 1, name = "Кухня", apartmentId = 1),
//            Room2(id = 2, name = "Спальня", apartmentId = 1),
//            Room2(id = 3, name = "Ванная", apartmentId = 1),
//            Room2(id = 4, name = "Туалет", apartmentId = 1),
//            Room2(id = 5, name = "Мастер-комната", apartmentId = 2),
//        )
//
//        lifecycleScope.launch {
//            users.forEach { dao.createUser2(it) }
//            apartments.forEach { dao.createApartment2(it) }
//            rooms.forEach { dao.createRoom2(it) }
//
//            val res: List<UsersWithApartmentsAndRooms> = dao.getUsersAndApartsAndRoomsRelation()
//
//            Log.d("room", res.toString())
//        }

//        -----------------------------------------------
//        One To Many (Map)
//        val users = listOf(
//            Users(id = 1, name = "Test1"),
//            Users(id = 2, name = "Test2")
//        )
//
//        val apartments = listOf(
//            Apartment(id = 1, adress = "Moscow, Alexander Monahovoi", userId = 1),
//            Apartment(id = 2, adress = "Moscow, Ozernaya", userId = 1),
//            Apartment(id = 3, adress = "Moscow, Moscouski", userId = 2)
//        )
//
//        val rooms = listOf(
//            Room(id = 1, name = "Кухня", apartmentId = 1),
//            Room(id = 2, name = "Спальня", apartmentId = 1),
//            Room(id = 3, name = "Ванная", apartmentId = 1),
//            Room(id = 4, name = "Туалет", apartmentId = 1),
//            Room(id = 5, name = "Мастер-комната", apartmentId = 2),
//        )
//
//        lifecycleScope.launch {
//            users.forEach { dao.insertUser(it) }
//            apartments.forEach { dao.insertApartment(it) }
//            rooms.forEach { dao.insertRoom(it) }

//            val res = dao.getUserAndAparts2()
//            Log.d("room", res.toString())
//            val res2 = dao.getUsersAndApartmentsAndRooms() +++++
//            Log.d("room", res2.toString())
//            val res = dao.getUserAndAparts()
//            Log.d("room", res.toString())
//            val groupRes = dao.getUserAndApartmentCountMap(2)
//            Log.d("room", groupRes.toString())
//        }
    }
}