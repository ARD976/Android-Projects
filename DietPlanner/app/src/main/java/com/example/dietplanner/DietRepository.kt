package com.example.dietplanner

import androidx.lifecycle.LiveData

class DietRepository(val dao : DietDao) {

    var allDiet : LiveData<List<Diet>> = dao.getAllDiet()

    suspend fun insert(diet : Diet){
        dao.insert(diet)
    }

    suspend fun delete(diet: Diet){
        dao.delete(diet)
    }

}