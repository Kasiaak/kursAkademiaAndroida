package com.kasiaak.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kasiaak.kursakademiaandroida.features.episodes.presentation.EpisodeFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavbar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavbar = findViewById(R.id.bottom_navbar)
        bottomNavbar.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.navbar_episodes -> {
                    loadFragment(R.id.episode_container, EpisodeFragment())
                    return@setOnItemReselectedListener
                }
                R.id.navbar_characters -> {
                    // loadFragment()
                }
                R.id.navbar_locations -> {
                    //loadFragment()
                }
            }
        }

    }

    private fun loadFragment(containerViewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(containerViewId, fragment)
            .addToBackStack(null)
            .commit()
    }
}