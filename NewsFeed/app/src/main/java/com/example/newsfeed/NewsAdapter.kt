package com.example.newsfeed

import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide

class NewsAdapter(private val listener : NewsClicked) : RecyclerView.Adapter<NewsViewHolder>(){

    private val items = ArrayList<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news , parent , false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int){
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    fun updatedNews(updatedNews : ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

}

class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val titleView = itemView.findViewById<TextView>(R.id.titleView)
    val author = itemView.findViewById<TextView>(R.id.author)
    val image = itemView.findViewById<ImageView>(R.id.image)
}

interface NewsClicked {
    fun onItemClicked(item : News)
}

