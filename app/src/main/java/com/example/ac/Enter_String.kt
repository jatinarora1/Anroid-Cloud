package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var database: DatabaseReference
class Enter_String : AppCompatActivity() {
    val TAG = "Enter_String"
    private val CHANNEL = "channel_1"
    private val notification_ID = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        database = FirebaseDatabase.getInstance().getReference()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter__number2)

//        createNotificationChannel()
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)
        val editText: EditText = findViewById(R.id.Number)
        val uploadBtn: Button = findViewById(R.id.uploadNumber)
        uploadBtn.setOnClickListener {
//            sendNotification()
            val text = editText.text.toString()
            if(!text.isEmpty())
            {
                PushNotification(
                    NotificationData("New Notification","String Uploaded!!!"),
                    TOPIC
                ).also{
                    sendNotification(it)
                }
            }
            database.child("StringInput").push().setValue(text)


            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
            // [END subscribe_topics]
        }
    }



    private fun sendNotification(pushNotification: PushNotification) = CoroutineScope(Dispatchers.IO).launch{
        try{
            val response = RetrofitInstance.api.pushNotification(pushNotification)
            if(response.isSuccessful){
                Log.e(TAG, "Response: ${Gson().toJson(response)}")
            }
            else
            {
                Log.e(TAG, response.errorBody().toString())
            }
        }
        catch (e:Exception)
        {
            Log.e(TAG, e.toString())
        }




    }


}