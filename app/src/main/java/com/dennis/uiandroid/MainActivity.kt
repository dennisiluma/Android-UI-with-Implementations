package com.dennis.uiandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

//create a layout manager object

class MainActivity : AppCompatActivity() {
    // Notification channel ids
    var CHANNEL_ID = "ID"
    var CHANNEL_NAME = "NAME"
    var NOTIFICATION = 0

    //create a layout  and adapter object
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<PartnerSectionRecycler.ItemsHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        /*Notification activities*/
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentText("Hello Son")
            .setContentTitle("Click Me")
            .setSmallIcon(R.drawable.notification_icon)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        val btnNotification = findViewById<ImageView>(R.id.nav_icon)
        btnNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION, notification)
        }
        /* For Recycler View */
        var recyclerview = findViewById<RecyclerView>(R.id.home_recycler_view)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerview.layoutManager = layoutManager
        //initialize our adaptor
        adapter = PartnerSectionRecycler()
        recyclerview.adapter = adapter

        /*for Viewpager2*/

        val viewpager = findViewById<ViewPager2>(R.id.view_pager2)
        // fill data into the viewpager class
        var data = arrayListOf<DataViewPager>();
        data.add(DataViewPager("Dennis", "Debit Card", "$23,095", "2562", "VISA", R.color.blue))
        data.add(DataViewPager("Dapo", "Credit Card", "$93,095", "1562", "VISA", R.color.red))
        data.add(DataViewPager("Ola", "Debit Card", "$63,095", "0567", "VISA", R.color.green))
        data.add(DataViewPager("Zambia", "credit Card", "$13,095", "4562", "VISA", R.color.red))
        viewpager.adapter = CardViewAdapter(this, data)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //connect it to the Circularindicator view
        val indicator = findViewById<CircleIndicator3>(R.id.indicator3)
        indicator.setViewPager(viewpager)
    }

    //create notification channel
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                enableLights(true)
                lightColor = Color.BLUE
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}