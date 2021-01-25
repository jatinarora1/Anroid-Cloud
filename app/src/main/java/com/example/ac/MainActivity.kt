package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result.toString()

//             Log and toast
//            val msg = getString(R.string.msg_token_fmt, token)
            Log.d(TAG, token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()

        })


        val updateBtn: Button = findViewById(R.id.updateBtn)
        updateBtn.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
        val retrieveBtn: Button = findViewById(R.id.retrieveBtn)
        retrieveBtn.setOnClickListener {
            val i = Intent(this, Retrieve::class.java)
            startActivity(i)
        }

    }
    override fun onBackPressed() {
        val exitIntent = Intent(Intent.ACTION_MAIN)
        exitIntent.addCategory(Intent.CATEGORY_HOME)
        exitIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(exitIntent)
    }

    companion object {

        private const val TAG = "MainActivity"
    }
}