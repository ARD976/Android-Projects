package com.example.aewroster

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Word::class] , version = 1 , exportSchema = false)
abstract class WordDatabase : RoomDatabase(){

    abstract fun getWordDao() : WordDao

    companion object{

        @Volatile
        private var INSTANCE : WordDatabase? = null

        fun getDatabase(context: Context) : WordDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = databaseBuilder(
                    context.applicationContext ,
                    WordDatabase::class.java ,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }

    }

}