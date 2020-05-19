package com.fgc.musicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        thread {
            Thread.sleep((3 * 1000).toLong())
            startMainActivity()
        }.priority = Thread.NORM_PRIORITY
    }

    private fun startMainActivity() {
        //val intent = Intent(applicationContext, ProfileUserActivity::class.java)
        //startActivity(intent)
        finish()
    }
}