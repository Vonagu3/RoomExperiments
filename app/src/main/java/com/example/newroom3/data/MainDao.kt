package com.example.newroom3.data
import androidx.room.*
import com.example.newroom3.data.manyToMany.*
import com.example.newroom3.data.oneToMany.Apartment
import com.example.newroom3.data.oneToMany.Room
import com.example.newroom3.data.oneToMany.Users
import com.example.newroom3.data.oneToManyRelation.Apartment2
import com.example.newroom3.data.oneToManyRelation.ApartmentWithRooms
import com.example.newroom3.data.oneToManyRelation.Room2
import com.example.newroom3.data.oneToManyRelation.User2
import com.example.newroom3.data.oneToManyRelation.UserWithApartments
import com.example.newroom3.data.oneToManyRelation.UsersWithApartmentsAndRooms

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: Users)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApartment(apartment: Apartment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: Room)

//    @MapInfo(keyColumn = "userName")
//    @Query("SELECT Users.name as userName, Apartment.* FROM Users JOIN Apartment ON Users.id = Apartment.userId")
//    suspend fun getUserAndAparts(): Map<String,List<Apartment>>

    @Query("SELECT * FROM Users JOIN Apartment ON Users.id = Apartment.userId")
    suspend fun getUserAndAparts2(): Map<Users,List<Apartment>>

//    @Query("SELECT * FROM Users JOIN Apartment ON Users.id = Apartment.userId " +
//            "JOIN Room ON Apartment.id = Room.apartmentId")
//    suspend fun getUsersAndApartmentsAndRooms(): Map<Users, List<ApartmentWithRooms>>

    @Transaction
    @Query("SELECT * FROM User2")
    suspend fun getUsersAndApartsAndRoomsRelation(): List<UsersWithApartmentsAndRooms>

//    @Query("SELECT * FROM Users JOIN Apartment ON Users.id = Apartment.userId")
//    suspend fun getUserAndAparts3(): Map<Users,List<Apartment>>

//    @MapInfo(valueColumn = "apartmentCount")
//    @Query("SELECT *, COUNT(Apartment.id) as apartmentCount FROM Users JOIN Apartment ON Users.id = Apartment.userId GROUP BY name HAVING apartmentCount = :apartmentCount")
//    suspend fun getUserAndApartmentCountMap(apartmentCount: Int): Map<Users, Integer>

//    -----------------------------------------
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(join: CourseWithInstructor)
//
//    @Transaction
//    @Query("SELECT * FROM Course")
//    fun getCourses(): Flow<List<CourseInstructorPair>>

//    ---------------------------------------------
//    one to many (Relation)
    @Transaction
    @Query("SELECT * FROM User2")
    suspend fun getUsersWithApartments(): List<UserWithApartments>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser2(user2: User2)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createApartment2(apartment2: Apartment2)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createRoom2(room2: Room2)

//    ----------------------------------------------
//    many to many(Relation)
    @Transaction
    @Query("SELECT * FROM Course")
    suspend fun getInstructorsOfCourse(): List<InstructorsOfCourse>

    @Transaction
    @Query("SELECT * FROM Instructor")
    suspend fun getCoursesOfInstructor(): List<CoursesOfInstructor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInstructor(instructor: Instructor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourseWithInstructor(courseWithInstructor: CourseWithInstructor)

}