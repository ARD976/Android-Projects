package com.example.dietplanner

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DietViewModel(application: Application) : AndroidViewModel(application) {

    val allDiet : LiveData<List<Diet>>
    val repository : DietRepository

    init {
        val dao = DietDatabase.getDatabase(application).getDao()
        repository = DietRepository(dao)
        allDiet = repository.allDiet
    }

    fun insert(diet: Diet) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(diet)
    }

    fun delete(diet: Diet) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(diet)
    }

}