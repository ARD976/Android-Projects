package com.example.moneyview

import androidx.lifecycle.LiveData

class MoneyRepository(private val dao : MoneyDao) {

    val allMoney : LiveData<List<Money>> = dao.getAllMoney()

    suspend fun insert(money: Money){
        dao.insert(money)
    }

    suspend fun delete(money: Money){
        dao.delete(money)
    }

}