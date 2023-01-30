package com.semnazri.vgdb.domain.local

import com.semnazri.vgdb.db.repository.GameLocalRepository
import com.semnazri.vgdb.model.CacheGame

interface GetLocalGameUseCase {
    suspend fun execute():  List<CacheGame>
}

class GetLocalGameUseCaseImpl(private val gameLocalRepository: GameLocalRepository) : GetLocalGameUseCase {
    override suspend fun execute(): List<CacheGame> {
        return gameLocalRepository.getFavoriteGame()
    }

}

