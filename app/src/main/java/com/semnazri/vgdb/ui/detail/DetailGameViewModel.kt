package com.semnazri.vgdb.ui.detail

import com.semnazri.vgdb.base.BaseViewModel
import com.semnazri.vgdb.domain.remote.GetDetailGameUseCase
import com.semnazri.vgdb.model.details.GameDetailResponse
import com.semnazri.vgdb.util.ResultCall
import kotlinx.coroutines.launch

class DetailGameViewModel(private val getDetailGameUseCase: GetDetailGameUseCase) :
    BaseViewModel<DetailGameViewModel.Event, DetailGameViewModel.State>() {

    sealed class Event {
        data class LoadGameById(val gameId: Int) : Event()
    }

    sealed class State {
        data class ShowDetailGame(val gameData: GameDetailResponse) : State()
        object ShowError : State()
    }

    override fun callEvent(event: Event) {
        when (event) {
            is Event.LoadGameById -> getDetailGame(event.gameId)
        }
    }

    private fun getDetailGame(gameId: Int) = launch {
        when (val result = getDetailGameUseCase.execute(id = gameId)) {
            is ResultCall.Success -> setState(State.ShowDetailGame(result.data))
            else -> setState(State.ShowError)
        }
    }

}
