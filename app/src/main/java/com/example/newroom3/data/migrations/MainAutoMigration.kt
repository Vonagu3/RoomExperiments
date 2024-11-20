package com.example.newroom3.data.migrations

import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.RenameTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@RenameColumn(tableName = "User", fromColumnName = "surName", toColumnName = "name")
class Migration1: AutoMigrationSpec{}

@DeleteColumn(tableName = "User", columnName = "weight")
class Migration2: AutoMigrationSpec{}

@RenameColumn(tableName = "User", fromColumnName = "weight", toColumnName = "height")
class Migration3: AutoMigrationSpec{}

@RenameTable(fromTableName = "User", toTableName = "Users")
class Migration4: AutoMigrationSpec{}
//@RenameColumn(tableName = "User", fromColumnName = "height", toColumnName = "weight")
//class Migration2: AutoMigrationSpec{}

