package com.example.moneyview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MoneyAdapter(private val context: Context , private val listener : MRVInterface , private val viewModel: MoneyViewModel) : RecyclerView.Adapter<MoneyAdapter.NotesViewHolder>() {

    val allMoney = ArrayList<Money>()

    inner class NotesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val amout = itemView.findViewById<TextView>(R.id.amount)
        val delete = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_money , parent , false))
        viewHolder.delete.setOnClickListener {
            listener.onItemDelete(allMoney[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allMoney.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val current = allMoney[position]
        holder.name.text = current.name
        holder.amout.text = current.amount.toString()
    }

    fun update(newList : List<Money>){
        allMoney.clear()
        allMoney.addAll(newList)
        notifyDataSetChanged()
    }

}

interface MRVInterface{
    fun onItemDelete(money: Money)
}