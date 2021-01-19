package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val updateBtn : Button = findViewById(R.id.updateBtn)
        updateBtn.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
        val retrieveBtn: Button = findViewById(R.id.retrieveBtn)
        retrieveBtn.setOnClickListener {
            val i = Intent(this,Retrieve::class.java)
            startActivity(i)
        }
    }

    override fun onBackPressed() {
        val exitIntent = Intent(Intent.ACTION_MAIN)
        exitIntent.addCategory(Intent.CATEGORY_HOME)
        exitIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(exitIntent)
    }
}