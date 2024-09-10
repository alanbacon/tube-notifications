package com.alanbacon.tube_notifications;
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

import android.content.Context
import android.app.AlarmManager
import android.content.Intent
import android.app.PendingIntent

import com.alanbacon.tube_notifications.AlarmReceiver

import android.util.Log

class AlarmModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    var context = reactContext.getApplicationContext()

    override fun getName() = "AlarmModule"

    @ReactMethod fun createAlarm(name: String) {
        val alarmManager = this.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        // Intent part
        val intent = Intent(this.context, AlarmReceiver::class.java)
        intent.action = "TUBE_NOTIFICATION_ALARM_ACTION"
        intent.putExtra("NAME", name)

        val pendingIntent = PendingIntent.getBroadcast(this.context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Alarm time
        val ALARM_DELAY_IN_SECOND = 10
        val alarmTimeAtUTC = System.currentTimeMillis() + ALARM_DELAY_IN_SECOND * 1_000L

        // Set with system Alarm Service
        // Other possible functions: setExact() / setRepeating() / setWindow(), etc
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTimeAtUTC, pendingIntent)
    }
}