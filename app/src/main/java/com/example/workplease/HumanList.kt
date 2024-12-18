package com.example.workplease

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HumanList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_human_list)
//
//        val recyclerView: RecyclerView = findViewById(R.id.recycleViewPeople)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Fetch the list from SharedPreferences
//        val personList = getPersonList(this)
//        val adapter = PersonAdapter(personList)
//
//        recyclerView.adapter = adapter
    }
}