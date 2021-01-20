package com.example.ac

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

var input = ArrayList<String>()
private lateinit var database: DatabaseReference
class InputString : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_string)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.item_row2,R.id.textView,input)
        database = FirebaseDatabase.getInstance().getReference()
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter
        val childEventListener = object: ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val data = snapshot.getValue(String::class.java)
                if (data != null) {
                    input.add(data)
                }
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        input.clear()
        database.child("StringInput").addChildEventListener(childEventListener)
    }

}