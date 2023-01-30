package com.semnazri.vgdb.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semnazri.vgdb.model.CacheGame

@Dao
interface LikedGameLocalSource {

    @Query("SELECT * FROM games")
    fun getGames(): List<CacheGame>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGame(gameModel: CacheGame)

    @Query("DELETE FROM games WHERE games_id = :id")
    fun removeFavoriteGame(id: Long): Int
}