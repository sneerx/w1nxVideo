package com.w1nxclub.winxvideo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.presentation.membership.login.LoginFragment
import com.w1nxclub.winxvideo.presentation.membership.login.LoginFragment_GeneratedInjector
import com.w1nxclub.winxvideo.presentation.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.GONE

            // Hedef fragmenta geçiş yapma işlemi
            val fragment = LoginFragment()
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit()
            finish()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

             // SplashScreen'u kapat


        }, 3000) // 3 saniye bekleniyor


    }
}