package com.example.notesview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), IRVNoteAdapter {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this , this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this ,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this , Observer {list ->
            list?.let {
                adapter.update(it)
            }
        })
    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this , "${note.text} is deleted" , Toast.LENGTH_SHORT).show()
    }

    fun updateList(view: View) {
        val input = findViewById<EditText>(R.id.input)
        val name = input.text.toString()
        if(name.isNotEmpty()){
            viewModel.insertNote(Note(name))
        }
        Toast.makeText(this , "$name is inserted" , Toast.LENGTH_SHORT).show()
    }

}

