package com.example.newroom3.data.manyToMany

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class InstructorsOfCourse(
    @Embedded
    var course: Course,

    @Relation(
        parentColumn = "courseId",
        entityColumn = "instructorId",
        associateBy = Junction(CourseWithInstructor::class)
    )
    var instructor: List<Instructor>
)

data class CoursesOfInstructor(
    @Embedded
    var instructor: Instructor,

    @Relation(
        parentColumn = "instructorId",
        entityColumn = "courseId",
        associateBy = Junction(CourseWithInstructor::class)
    )
    var courses: List<Course>
)