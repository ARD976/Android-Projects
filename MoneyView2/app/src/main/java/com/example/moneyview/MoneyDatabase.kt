package com.example.moneyview

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Money::class) , version = 1 , exportSchema = false)
abstract class MoneyDatabase : RoomDatabase(){

    abstract fun getDao() : MoneyDao

    companion object{

        @Volatile
        private var Instance : MoneyDatabase? = null

        fun getDatabase(context: Context) : MoneyDatabase{

            return Instance ?: synchronized(this){
                val instance = databaseBuilder(
                    context.applicationContext ,
                    MoneyDatabase::class.java ,
                    "money_database"
                ).build()
                Instance = instance
                instance
            }
        }

    }

}