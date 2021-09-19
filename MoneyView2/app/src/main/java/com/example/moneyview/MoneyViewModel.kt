package com.example.moneyview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoneyViewModel(application: Application) : AndroidViewModel(application) {

     val allMoney : LiveData<List<Money>>

    val repository : MoneyRepository

    init {
        val dao = MoneyDatabase.getDatabase(application).getDao()

        repository = MoneyRepository(dao)

        allMoney = repository.allMoney
    }

    fun insert(money: Money) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(money)
    }

    fun delete(money: Money) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(money)
    }

}