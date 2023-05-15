package com.w1nxclub.winxvideo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.setGone
import com.w1nxclub.winxvideo.core.util.setVisible
import com.w1nxclub.winxvideo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavBar.setupWithNavController(
            Navigation.findNavController(
                this@MainActivity,
                R.id.navHostFragment
            )
        )

        navbarVisibility()
    }

    private fun navbarVisibility() {
        binding.apply {

            val navController = findNavController(R.id.navHostFragment)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.loginFragment -> bottomNavBar.setGone()
                    R.id.registerFragment -> bottomNavBar.setGone()
                    else -> bottomNavBar.setVisible()
                }
            }
        }
    }
}