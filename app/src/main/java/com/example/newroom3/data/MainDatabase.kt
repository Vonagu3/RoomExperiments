package com.example.newroom3.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newroom3.data.manyToMany.Course
import com.example.newroom3.data.manyToMany.CourseWithInstructor
import com.example.newroom3.data.manyToMany.Instructor
import com.example.newroom3.data.migrations.Migration1
import com.example.newroom3.data.migrations.Migration2
import com.example.newroom3.data.migrations.Migration3
import com.example.newroom3.data.migrations.Migration4
import com.example.newroom3.data.oneToMany.Apartment
import com.example.newroom3.data.oneToMany.Users
import com.example.newroom3.data.oneToManyRelation.Apartment2
import com.example.newroom3.data.oneToManyRelation.Room2
import com.example.newroom3.data.oneToManyRelation.User2


@Database(
    version = 1,//13,
    entities = [
        Users::class,
        Apartment::class,
        com.example.newroom3.data.oneToMany.Room::class,
        User2::class,
        Apartment2::class,
        Room2::class,
        Instructor::class,
        Course::class,
        CourseWithInstructor::class
    ],
//
//    autoMigrations = [
//        AutoMigration (from = 4, to = 5, spec = Migration1::class),
//        AutoMigration (from = 5, to = 6),
//        AutoMigration(from = 6, to = 7),
//        AutoMigration(from = 7, to = 8, spec = Migration2::class),
//        AutoMigration(from = 8, to = 9),
//        AutoMigration(from = 9, to = 10),
//        AutoMigration(from = 10, to = 11),
//        AutoMigration(from = 11, to = 12, spec = Migration3::class),
//        AutoMigration(from = 12, to = 13, spec = Migration4::class)
//    ],
//    exportSchema = true
)
abstract class MainDatabase(): RoomDatabase() {

    abstract val mainDao: MainDao

    companion object{
        @Volatile
        private var INSTANCE: MainDatabase?= null

        fun getInstance(context: Context): MainDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "main_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}