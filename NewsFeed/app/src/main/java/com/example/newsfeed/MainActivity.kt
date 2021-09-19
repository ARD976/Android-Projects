 package com.example.newsfeed

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity() : AppCompatActivity(), NewsClicked {

    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
        mAdapter = NewsAdapter(this)
        recyclerView.adapter = mAdapter

    }

    private fun fetchData() {
        val url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=1e232e6eae24456e9537ce8eece2b8ad"
        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET , url , null , Response.Listener {
            val newsJsonArray = it.getJSONArray("articles")
            val newsArray = ArrayList<News>()
            for(i in 0 until newsJsonArray.length()){
                val newsJsonObject = newsJsonArray.getJSONObject(i)
                val news = News(
                    newsJsonObject.getString("author") ,
                    newsJsonObject.getString("title") ,
                    newsJsonObject.getString("url") ,
                    newsJsonObject.getString("urlToImage")
                )
                newsArray.add(news)
            }
            mAdapter.updatedNews(newsArray)
        } ,
        Response.ErrorListener {}){
            override fun getHeaders() : MutableMap<String , String>{
                val headers = HashMap<String , String>()
                headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
        
    }

    override fun onItemClicked(item: News){
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}