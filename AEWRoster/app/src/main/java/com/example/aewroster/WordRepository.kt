package com.example.aewroster

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    val getAllWords : LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    suspend fun delete(word: Word){
        wordDao.delete(word)
    }

}