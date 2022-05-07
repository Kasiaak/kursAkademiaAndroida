package com.kasiaak.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kasiaak.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.kasiaak.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.kasiaak.kursakademiaandroida.features.locations.presentation.LocationFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavbar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavbar = findViewById(R.id.bottom_navbar)
        bottomNavbar.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.navbar_episodes -> {
                    loadFragment(EpisodeFragment())
                    return@setOnItemReselectedListener
                }
                R.id.navbar_characters -> {
                    loadFragment(CharacterFragment())
                    return@setOnItemReselectedListener
                }
                R.id.navbar_locations -> {
                    loadFragment(LocationFragment())
                    return@setOnItemReselectedListener
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}