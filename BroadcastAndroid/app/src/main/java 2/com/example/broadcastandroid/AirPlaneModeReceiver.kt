package com.example.broadcastandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val airPlaneModeChanged = intent?.getBooleanExtra("state" , false)?:return
        if(airPlaneModeChanged)
            Toast.makeText(context , "AirPlane mode is enabled..." , Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context , "AirPlane mode is enabled..." , Toast.LENGTH_SHORT).show()
    }
}