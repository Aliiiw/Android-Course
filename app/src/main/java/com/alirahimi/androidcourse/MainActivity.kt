package com.alirahimi.androidcourse

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.alirahimi.androidcourse.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialNotification0()
        //initialNotification1()
    }

    private fun initialNotification0() {

        binding.buttonShowNotification.setOnClickListener {

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val notification = NotificationCompat
                .Builder(this, Constants.NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.notif
                    )
                )
                .setContentTitle("Aliiiw")
                .setContentText("Let's go self")
                .build()

            notificationManager.notify(0, notification)
            //TODO random

        }
    }

    private fun initialNotification1() {

        binding.buttonShowNotification.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 15, intent, PendingIntent.FLAG_IMMUTABLE)

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val notification = NotificationCompat
                .Builder(this, Constants.NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.notif
                    )
                )
                .setContentTitle("Aliiiw")
                .setContentText("Let's go self")
                .setContentIntent(pendingIntent)
                .build()

            notificationManager.notify(0, notification)
            //TODO random

        }
    }

    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}