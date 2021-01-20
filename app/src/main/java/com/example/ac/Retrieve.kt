package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Retrieve : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve)
        val homeBtn: Button = findViewById(R.id.home)
        homeBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        val numBtn: Button = findViewById(R.id.Number)
        numBtn.setOnClickListener {
            val i = Intent(this, Numbers::class.java)
            startActivity(i)
        }
        val numBtn1: Button = findViewById(R.id.strings)
        numBtn1.setOnClickListener {
            val i = Intent(this, InputString::class.java)
            startActivity(i)
        }
    }
    override fun onBackPressed() {
        val i = Intent(this, MainActivity::class.java)

        startActivity(i)
    }
}