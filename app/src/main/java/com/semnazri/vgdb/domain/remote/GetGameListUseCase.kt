package com.semnazri.vgdb.domain.remote

import com.semnazri.vgdb.model.list.GameListResponse
import com.semnazri.vgdb.network.repository.GameRepository
import com.semnazri.vgdb.util.ResultCall

interface GetGameListUseCase {
    suspend fun execute(page: Int): ResultCall<GameListResponse>
}

class GetGameListUseCaseImpl(private val gameRepository: GameRepository) : GetGameListUseCase {
    override suspend fun execute(page: Int): ResultCall<GameListResponse> {
        return gameRepository.requestListGame(page = page)
    }

}