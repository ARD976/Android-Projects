package com.example.dietplanner

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diet_table")
class Diet(@ColumnInfo(name = "name") val name : String, @ColumnInfo(name = "count")val count : Int) {
    @PrimaryKey(autoGenerate = true) var id = 0
}