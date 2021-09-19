package com.example.aewroster

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roster")
class Word(@ColumnInfo(name = "name") val name : String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}