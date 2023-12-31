package com.kdt.githubuserakhir.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.kdt.githubuserakhir.R
import com.kdt.githubuserakhir.databinding.ActivitySplashScreenBinding
import com.kdt.githubuserakhir.ui.main.MainActivity


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        textAnimated()
        moveToMainActivity()
    }

    private fun textAnimated() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.appName.animation = anim

    }

    private fun moveToMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 3000L)
    }
}