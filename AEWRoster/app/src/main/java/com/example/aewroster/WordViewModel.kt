package com.example.aewroster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application){

    val allWords : LiveData<List<Word>>
    private val repository : WordRepository

    init {
        val dao = WordDatabase.getDatabase(application).getWordDao()
        repository = WordRepository(dao)
        allWords = repository.getAllWords
    }

    fun insertWord(word : Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

    fun deleteWord(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(word)
    }

}

