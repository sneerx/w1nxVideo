package com.w1nxclub.winxvideo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.presentation.membership.login.LoginFragment
import com.w1nxclub.winxvideo.presentation.membership.login.LoginFragment_GeneratedInjector
import com.w1nxclub.winxvideo.presentation.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)

            progressBar.visibility = View.GONE

            val fragment = LoginFragment()
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit()

            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}