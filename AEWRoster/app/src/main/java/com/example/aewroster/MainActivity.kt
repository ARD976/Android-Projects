package com.example.aewroster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), IRVWordAdapter {

    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = WordAdapter(this , this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this ,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WordViewModel::class.java)
        viewModel.allWords.observe(this , Observer {list ->
            list?.let {
                adapter.update(it)
            }
        })

    }

    override fun onDelete(word: Word) {
        viewModel.deleteWord(word)
    }

    fun add(view: View) {
        val edit = findViewById<EditText>(R.id.input)
        val name = edit.text.toString()
        if(name.isNotEmpty()){
            viewModel.insertWord(Word(name))
        }
    }


}