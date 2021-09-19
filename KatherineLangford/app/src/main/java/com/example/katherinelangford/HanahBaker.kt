package com.example.katherinelangford

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HanahBaker : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA = "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanah_baker)
        val name = intent.getStringExtra(NAME_EXTRA)
        val hanah = findViewById<TextView>(R.id.hanah)
        hanah.text = name
    }
}