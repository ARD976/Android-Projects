package com.example.notesview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context: Context , private val listener : IRVNoteAdapter) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    val allNotes = ArrayList<Note>()

    inner class NotesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvname = itemView.findViewById<TextView>(R.id.tvName)
        val ivDelete = itemView.findViewById<ImageView>(R.id.ivDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes , parent , false))
        viewHolder.ivDelete.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.tvname.text = currentNote.text
    }

    fun update(newList : List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}

interface IRVNoteAdapter{
    fun onItemClicked(note: Note)
}