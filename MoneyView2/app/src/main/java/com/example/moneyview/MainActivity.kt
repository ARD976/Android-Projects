package com.example.moneyview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MRVInterface {

    lateinit var viewModel: MoneyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this ,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MoneyViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MoneyAdapter(this , this , viewModel)
        recyclerView.adapter = adapter

        viewModel.allMoney.observe(this , Observer {list->
            list?.let{
                adapter.update(it)
            }
        })

        val add = findViewById<Button>(R.id.add)
        add.setOnClickListener {
            val etName = findViewById<EditText>(R.id.etName)
            val name = etName.text.toString()
            val etAmount = findViewById<EditText>(R.id.etAmount)
            val amount = etAmount.text.toString().toInt()
            viewModel.insert(Money(name , amount))
        }

    }

    override fun onItemDelete(money: Money) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
                .setMessage("Do you really want to delete.")
                .setPositiveButton("Yes"){dialog, which ->
                    viewModel.delete(money)
                }
                .setNegativeButton("No"){dialog, which ->
                    dialog.cancel()
                }
        builder.show()
    }

}