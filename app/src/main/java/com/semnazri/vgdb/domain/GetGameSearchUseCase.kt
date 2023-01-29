package com.semnazri.vgdb.domain

import com.semnazri.vgdb.model.list.GameListResponse
import com.semnazri.vgdb.network.repository.GameRepository
import com.semnazri.vgdb.util.ResultCall

interface GetGameSearchUseCase {
    suspend fun execute(search : String, page: Int): ResultCall<GameListResponse>
}

class GetGameSearchUseCaseImpl(private val gameRepository: GameRepository) : GetGameSearchUseCase {
    override suspend fun execute(search: String, page: Int): ResultCall<GameListResponse> {
        return gameRepository.requestSearchGame(searchKey = search, page = page)
    }

}