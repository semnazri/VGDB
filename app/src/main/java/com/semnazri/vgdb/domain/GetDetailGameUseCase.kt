package com.semnazri.vgdb.domain

import com.semnazri.vgdb.model.details.GameDetailResponse
import com.semnazri.vgdb.network.repository.GameRepository
import com.semnazri.vgdb.util.ResultCall

interface GetDetailGameUseCase {
    suspend fun execute(id: Int): ResultCall<GameDetailResponse>
}

class GetDetailGameUseCaseImpl(private val gameRepository: GameRepository) : GetDetailGameUseCase {
    override suspend fun execute(id: Int): ResultCall<GameDetailResponse> {
        return gameRepository.requestDetailGame(gameID = id)
    }

}

