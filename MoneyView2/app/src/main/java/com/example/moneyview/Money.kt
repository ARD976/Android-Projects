package com.example.moneyview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "money_table")
class Money (@ColumnInfo(name = "name")val name : String, @ColumnInfo(name = "amout")val amount : Int){
    @PrimaryKey(autoGenerate = true) var id : Int = 0;
}