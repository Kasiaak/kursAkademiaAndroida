package com.kasiaak.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kasiaak.kursakademiaandroida.features.episodes.presentation.EpisodeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.episode_container, EpisodeFragment())
            .commit()
    }
}