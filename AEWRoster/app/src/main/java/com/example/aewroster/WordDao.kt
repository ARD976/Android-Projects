package com.example.aewroster

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word : Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("Select * from roster order by id ASC")
    fun getAllWords() : LiveData<List<Word>>

}