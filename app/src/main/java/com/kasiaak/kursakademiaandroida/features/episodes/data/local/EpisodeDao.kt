package com.kasiaak.kursakademiaandroida.features.episodes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kasiaak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM EpisodeCached")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episode: EpisodeCached)
}