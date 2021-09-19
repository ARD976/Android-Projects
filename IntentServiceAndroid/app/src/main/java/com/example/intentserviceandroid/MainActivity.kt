package com.example.intentserviceandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)
        val tv = findViewById<TextView>(R.id.tvIntent)

        start.setOnClickListener {
            Intent(this , MyIntentService::class.java).also {intent ->
                startService(intent)
                tv.text = "Service is running.."
            }
        }

        stop.setOnClickListener {
            Intent(this , MyIntentService::class.java).also {
                MyIntentService.stopService()
                tv.text = "Service is stopping.."
            }
        }

    }
}