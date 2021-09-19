package com.example.birthdaycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createBirthdayCard(view: View) {

        val name = nameInput.editableText.toString();

        Toast.makeText(context: this , text: "Name is $name" , Toast.LENGTH_LONG).show()

    }
}