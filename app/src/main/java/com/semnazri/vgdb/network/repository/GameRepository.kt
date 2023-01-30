package com.semnazri.vgdb.network.repository

import com.semnazri.vgdb.data.remote.GameRemoteSource
import com.semnazri.vgdb.model.details.GameDetailResponse
import com.semnazri.vgdb.model.list.GameListResponse
import com.semnazri.vgdb.util.ResultCall
import com.semnazri.vgdb.util.awaitCall
import com.semnazri.vgdb.util.mapTo

interface GameRepository {
    suspend fun requestListGame(page: Int = 1): ResultCall<GameListResponse>
    suspend fun requestSearchGame(searchKey: String, page: Int): ResultCall<GameListResponse>
    suspend fun requestDetailGame(gameID: Int): ResultCall<GameDetailResponse>
}

class GameRepositoryImpl(private val gameRemoteSource: GameRemoteSource) : GameRepository{

    override suspend fun requestListGame(page: Int): ResultCall<GameListResponse> {
        return awaitCall { gameRemoteSource.getGameList(page = page) }.mapTo {
            it
        }
    }

    override suspend fun requestSearchGame(
        searchKey: String,
        page: Int
    ): ResultCall<GameListResponse> {
        return awaitCall { gameRemoteSource.searchGame(searchKey = searchKey, page = page) }.mapTo {
            it
        }
    }

    override suspend fun requestDetailGame(gameID: Int): ResultCall<GameDetailResponse> {
        return awaitCall { gameRemoteSource.getGameDetail(id = gameID) }.mapTo {
            it
        }
    }

}