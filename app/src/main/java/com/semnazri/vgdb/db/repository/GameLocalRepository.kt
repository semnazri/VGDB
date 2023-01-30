package com.semnazri.vgdb.db.repository

import com.semnazri.vgdb.data.local.LikedGameLocalSource
import com.semnazri.vgdb.model.CacheGame

interface GameLocalRepository {
    suspend fun getFavoriteGame(): List<CacheGame>
    suspend fun addFavoriteGame(item: CacheGame)
    suspend fun deleteFavoriteGame(gameID: Long)

}

class GameLocalRepositoryImpl(private val localSource: LikedGameLocalSource) : GameLocalRepository {

    override suspend fun getFavoriteGame(): List<CacheGame> {
        return localSource.getGames()
    }

    override suspend fun addFavoriteGame(item: CacheGame) {
        localSource.addGame(item)
    }

    override suspend fun deleteFavoriteGame(gameID: Long) {
        localSource.removeFavoriteGame(gameID)
    }


}