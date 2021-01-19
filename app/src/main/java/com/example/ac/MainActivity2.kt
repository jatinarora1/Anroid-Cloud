package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val homeBtn: Button = findViewById(R.id.home)
        homeBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        val uploadNumberBtn: Button = findViewById(R.id.uploadNumber)
        uploadNumberBtn.setOnClickListener {
            val i = Intent(this, Enter_Number::class.java)
            startActivity(i)
        }
        val uploadStringBtn: Button = findViewById(R.id.uploadString)
        uploadStringBtn.setOnClickListener {
            val i = Intent(this, Enter_String::class.java)
            startActivity(i)
        }
    }
}