package com.semnazri.vgdb.domain.local

import com.semnazri.vgdb.db.repository.GameLocalRepository
import com.semnazri.vgdb.model.CacheGame

interface AddLocalGameUseCase {
    suspend fun execute(games : CacheGame)
}

class AddLocalGameUseCaseImpl(private val gameLocalRepository: GameLocalRepository) : AddLocalGameUseCase {
    override suspend fun execute(games: CacheGame) {
       return gameLocalRepository.addFavoriteGame(games)
    }

}

