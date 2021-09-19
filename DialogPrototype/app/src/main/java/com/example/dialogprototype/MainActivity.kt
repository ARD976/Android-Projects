package com.example.dialogprototype

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            val builder = AlertDialog.Builder(this)

            builder.setTitle(R.string.dialogTitle)

            builder.setMessage(R.string.dialogMessage)

            builder.setPositiveButton("Yes"){ dialog: DialogInterface?, which: Int ->
                finish()
                Toast.makeText(applicationContext , "Yes was selected." , Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton("No"){ dialog, which ->
                dialog.cancel()
                Toast.makeText(applicationContext , "No was selected." , Toast.LENGTH_SHORT).show()
            }

            val alertDialog : AlertDialog = builder.create()

            alertDialog.setCancelable(false)

            alertDialog.show()

        }

        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {

            val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog , null)

            val builder = AlertDialog.Builder(this)
                .setView(view)
                .setTitle("Add")
                .setMessage("Please Enter Your Name")

            val alertDialog = builder.show()

            val create = view.findViewById<Button>(R.id.create)

            create.setOnClickListener {

                alertDialog.dismiss()

                val edit = view.findViewById<TextView>(R.id.etName)

                val name = edit.text.toString()

                val info = findViewById<TextView>(R.id.info)

                info.setText(name)

            }

            val cancel = view.findViewById<Button>(R.id.cancel)

            cancel.setOnClickListener {

                alertDialog.dismiss()

            }




        }
    }
}