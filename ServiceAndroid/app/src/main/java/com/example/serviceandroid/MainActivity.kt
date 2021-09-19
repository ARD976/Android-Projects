package com.example.serviceandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)

        start.setOnClickListener {
            startService(Intent(this , NewService::class.java))
        }

        stop.setOnClickListener {
            stopService(Intent(this , NewService::class.java))
        }

    }
}