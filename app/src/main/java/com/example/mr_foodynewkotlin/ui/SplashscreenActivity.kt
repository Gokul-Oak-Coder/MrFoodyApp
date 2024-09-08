package com.example.mr_foodynewkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import com.example.mr_foodynewkotlin.R

class SplashscreenActivity : AppCompatActivity() {

    private val DURATION : Long = 2000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, DURATION)

    }
}