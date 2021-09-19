package com.example.listapp

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog

class AddShoppingItemDialog(context : Context) : AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        if (tvAdd != null) {
            tvAdd.setOnClickListener{
                val etName = findViewById<EditText>(R.id.etName)
                val name = etName?.text.toString()
            }
        }
    }

}