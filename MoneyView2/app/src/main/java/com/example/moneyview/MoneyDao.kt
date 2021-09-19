package com.example.moneyview

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoneyDao {

    @Insert
    suspend fun insert(money: Money)

    @Delete
    suspend fun delete(money: Money)

    @Query("Select * from money_table")
    fun getAllMoney() : LiveData<List<Money>>
}