package com.example.emaildesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = arrayListOf<Model>()
        for (i in 1..17) {
            val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            itemList.add(
                Model(
                    characters[Random().nextInt(characters.length)] + "random" + String.format("%03d", i) + "@gmail.com",
                    "Account Suspended",
                    "Your account has been suspended because we suspect you are engaging in improper activities.",
                    String.format(
                        "%02d:%02d %s",
                        Random().nextInt(12) + 1,
                        Random().nextInt(60),
                        if (Random().nextBoolean()) "AM" else "PM"
                    )
                )
            )
        }
        val recyclerView = findViewById<RecyclerView>(R.id.rvGmail)
        val adapter = RecyclerViewAdapter(itemList)

        // Sử dụng GridLayoutManager với spanCount bằng 1 để hiển thị một cột
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        recyclerView.adapter = adapter

        // Để hiển thị hàng cụ thể, sử dụng GridLayoutManager.scrollToPosition
        val targetRow = 5 // Hàng bạn muốn hiển thị
        recyclerView.layoutManager?.scrollToPosition(targetRow)
    }
}