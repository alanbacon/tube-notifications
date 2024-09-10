package com.alanbacon.tube_notifications;

import android.content.BroadcastReceiver
import android.widget.Toast
import android.content.Intent
import android.util.Log
import android.content.Context

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Is triggered when alarm goes off, i.e. receiving a system broadcast
        if (intent.action == "TUBE_NOTIFICATION_ALARM_ACTION") {
            val name = intent.getStringExtra("NAME")
            Log.d("AlarmReceiver", "Alarm event called with name: $name")
            Toast.makeText(context, name, Toast.LENGTH_LONG).show()
        }
    }
}