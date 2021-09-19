package com.example.dietplanner

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Diet::class] , version = 1 , exportSchema = false)
abstract class DietDatabase() : RoomDatabase() {

    abstract fun getDao() : DietDao

    companion object{

        private var INSTANCE : DietDatabase? = null

        fun getDatabase(context: Context) : DietDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = databaseBuilder(
                    context.applicationContext,
                    DietDatabase::class.java,
                    "diet_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }


}