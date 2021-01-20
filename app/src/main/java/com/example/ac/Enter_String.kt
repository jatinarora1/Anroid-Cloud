package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private lateinit var database: DatabaseReference

class Enter_String : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter__string)
        database = FirebaseDatabase.getInstance().getReference()
        val homeBtn: Button = findViewById(R.id.home)
        homeBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        val editText: EditText = findViewById(R.id.String)
        val uploadBtn: Button = findViewById(R.id.uploadString)
        uploadBtn.setOnClickListener {
            val string = editText.text.toString()
            database.child("StringInput").push().setValue(string)
            val i =Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

    }
}