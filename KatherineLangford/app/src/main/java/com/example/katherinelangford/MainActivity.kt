package com.example.katherinelangford

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createNewActivity(view: View) {
        val editText = findViewById<EditText>(R.id.nameInput)
        val name = editText.editableText.toString()
       // Toast.makeText(this , "$name" , Toast.LENGTH_LONG).show()
        val intent = Intent(this , HanahBaker::class.java)
        intent.putExtra(HanahBaker.NAME_EXTRA , name)
        startActivity(intent)
    }
}