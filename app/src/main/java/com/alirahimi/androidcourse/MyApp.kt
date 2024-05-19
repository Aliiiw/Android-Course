package com.alirahimi.androidcourse

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp : Application() {

    //TODO 1. first thing in android
    //TODO 2. register manifest

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val notificationChannel = NotificationChannel(
                Constants.NOTIFICATION_CHANNEL_ID,
                Constants.NOTIFICATION_CHANNEL_FOOTBALL_NAME, //user see that in setting
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.description = "this channel shows notifications about football"
            //other

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}