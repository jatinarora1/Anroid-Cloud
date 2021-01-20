package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private lateinit var database: DatabaseReference

class Enter_Number : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter__number)
        database = FirebaseDatabase.getInstance().getReference()
        val homeBtn: Button = findViewById(R.id.home)
        homeBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        val editText: EditText = findViewById(R.id.Number)
        val uploadBtn: Button = findViewById(R.id.uploadNumber)
        uploadBtn.setOnClickListener {
            val num = editText.text.toString()
            database.child("Number").push().setValue(num)
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
    }


}
