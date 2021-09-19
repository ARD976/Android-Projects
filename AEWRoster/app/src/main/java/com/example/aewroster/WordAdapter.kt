package com.example.aewroster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(context: Context , private val listener : IRVWordAdapter) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

   private val allWords = ArrayList<Word>()

    inner class WordViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val delete = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val viewHolder = WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word_item , parent , false))
        viewHolder.delete.setOnClickListener{
            listener.onDelete(allWords[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
       return allWords.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val currentWord = allWords[position]
        holder.name.text = currentWord.name
    }

    fun update(newList : List<Word>){
        allWords.clear()
        allWords.addAll(newList)
        notifyDataSetChanged()
    }

}

interface IRVWordAdapter{
    fun onDelete(word : Word)
}