package com.example.imagelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    private fun fetch(){
        val url = "https://api.pexels.com/v1/search?query=nature&per_page=1/"
        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET , url , null , Response.Listener {
            val jsonArray = it.getJSONArray("photos")
            for(i in 0 until jsonArray.length()){
                val photoJsonObject = jsonArray.getJSONObject(i)
                val imagesrc = photoJsonObject.getJSONObject("src")
                val small = imagesrc.getString("tiny")
                val imageView = findViewById<ImageView>(R.id.imageView)
                Glide.with(this).load(small).into(imageView)

            }
        },
        Response.ErrorListener {}){
            override fun getHeaders(): MutableMap<String, String> {
                val header = HashMap<String , String>()
                header["Authorization"] = "563492ad6f917000010000017da73ec8b3784ac29433623149233dc8"
                return header
            }
        }
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

}