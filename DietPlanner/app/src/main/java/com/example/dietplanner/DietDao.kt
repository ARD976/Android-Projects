package com.example.dietplanner

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DietDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(diet: Diet)

    @Delete
    suspend fun delete(diet: Diet)

    @Query("Select * from diet_table order by id ASC")
    fun getAllDiet() : LiveData<List<Diet>>

}