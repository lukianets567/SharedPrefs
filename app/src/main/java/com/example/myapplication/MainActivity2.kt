package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
    }
    private fun loadData(){
        val sharedPrefs = getSharedPreferences("123", Context.MODE_PRIVATE)
        val savedName = sharedPrefs.getString("EDIT_NAME", "null")
        val nameTextView = binding.nameTextView

        nameTextView.text = "Привіт, $savedName"
    }
}