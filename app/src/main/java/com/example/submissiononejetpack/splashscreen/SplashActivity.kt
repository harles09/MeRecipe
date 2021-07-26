package com.example.submissiononejetpack.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.submissiononejetpack.R
import com.example.submissiononejetpack.dashboard.DashboardActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val image: ImageView = findViewById(R.id.img_photo)

        //digunakan untuk menganimasi image dan durasi dari image tersebut
        image.alpha = 0f
        image.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}