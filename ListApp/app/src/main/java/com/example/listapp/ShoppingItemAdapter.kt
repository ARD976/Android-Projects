package com.example.listapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingItemAdapter(
    var items : List<ShoppingItem> ,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_shopping , parent , false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currShoppingItem = items[position]

        holder.tvName.text = currShoppingItem.name
        holder.tvAmount.text = "${currShoppingItem.amount}"

        holder.ivDelete.setOnClickListener{
            viewModel.delete(currShoppingItem)
        }

        holder.ivPlus.setOnClickListener{
            currShoppingItem.amount++
            viewModel.upsert(currShoppingItem)
        }

        holder.ivMinus.setOnClickListener{
            if(currShoppingItem.amount > 0){
            currShoppingItem.amount--
            viewModel.upsert(currShoppingItem)}
        }

    }

    inner class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvAmount = itemView.findViewById<TextView>(R.id.tvAmount)
        val ivDelete = itemView.findViewById<ImageView>(R.id.ivDelete)
        val ivPlus = itemView.findViewById<ImageView>(R.id.ivPlus)
        val ivMinus = itemView.findViewById<ImageView>(R.id.ivMinus)
    }

}