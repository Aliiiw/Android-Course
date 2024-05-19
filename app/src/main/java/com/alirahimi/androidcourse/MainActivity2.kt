package com.alirahimi.androidcourse

import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.alirahimi.androidcourse.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialBigPictureNotification()
        initialBigTextNotification()
        initialInboxNotification()

    }

    private fun initialBigPictureNotification() {
        binding.bigPictureStyleButton.setOnClickListener {
            val notificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

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
                .setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(
                            BitmapFactory.decodeResource(resources, R.drawable.big_pic)
                        )
                ).build()
            notificationManager.notify((10..1000).random(), notification)
        }
    }

    private fun initialBigTextNotification() {
        binding.bigTextStyleButton.setOnClickListener {
            val notificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
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
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(
                            "In publishing and graphic design, " +
                                    "Lorem ipsum is a placeholder text commonly used to demonstrate " +
                                    "the visual form of a document or a typeface without relying on " +
                                    "meaningful content. Lorem ipsum may be used as a placeholder " +
                                    "before the final copy is available. It is also used to temporarily" +
                                    " replace text in a process called greeking, which allows designers" +
                                    " to consider the form of a webpage or publication, without the " +
                                    "meaning of the text influencing the design"
                        )
                ).build()
            notificationManager.notify((10..1000).random(), notification)

        }
    }

    private fun initialInboxNotification() {
        binding.inboxStyleButton.setOnClickListener {
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
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("salam!")
                        .addLine("khoobi?!")
                        .addLine("seen nemikoni na ??????")
                        .addLine("bye for ever :))))")
                ).build()

            notificationManager.notify((10..1000).random(), notification)

        }
    }

    private fun initialBinding() {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}