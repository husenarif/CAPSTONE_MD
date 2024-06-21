package com.exemple.capstone.activity.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.capstone.activity.ui.main.LoginActivity
import com.exemple.capstone.R


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            goToLoginActivity()
        }, 3000L)
    }

    private fun goToLoginActivity() {
        Intent(this, LoginActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}


