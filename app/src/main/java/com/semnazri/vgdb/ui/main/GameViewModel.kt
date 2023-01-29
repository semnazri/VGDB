package com.semnazri.vgdb.ui.main

import com.semnazri.vgdb.base.BaseViewModel
import com.semnazri.vgdb.domain.GetGameSearchUseCase
import com.semnazri.vgdb.model.list.ResultsItem
import com.semnazri.vgdb.util.PreferencesManager
import com.semnazri.vgdb.util.ResultCall
import kotlinx.coroutines.launch

class GameViewModel(
    private val preferencesManager: PreferencesManager,
    private val getGameSearchUseCase: GetGameSearchUseCase
) : BaseViewModel<GameViewModel.Event, GameViewModel.State>() {

    private var page: Int = 2

    sealed class Event {
        data class LoadGameBySearch(val keyWord: String) : Event()
        object LoadGameBySearchMore : Event()
    }


    sealed class State {
        data class ShowGame(val gameList: List<ResultsItem>) : State()
        data class ShowGameMore(val gameList: List<ResultsItem>) : State()
        object ShowError : State()
    }

    override fun callEvent(event: Event) {
        when (event) {
            is Event.LoadGameBySearch -> requestGame(isLoadMore = false, keyword = event.keyWord)
            is Event.LoadGameBySearchMore -> requestGame(
                isLoadMore = true,
                keyword = preferencesManager.gameKeyword
            )
        }
    }

//    private fun loadGame(isLoadMore: Boolean, keyword: String) = launch {
//        val deferred = mutableListOf<Deferred<Any>>()
//        deferred.apply {
//            add(
//                requestGameAsync(isLoadMore = isLoadMore, keyWord = keyword)
//        )
//        }
//        deferred.awaitAll()
//    }

    private fun requestGame(isLoadMore: Boolean, keyword: String) = launch {

        if (isLoadMore) {
            when (val result = getGameSearchUseCase.execute(page = page++, search = keyword)) {
                is ResultCall.Success -> {
                    setState(State.ShowGameMore(result.data.results))
                }
                else -> setState(State.ShowError)
            }
        } else {
            when (val result = getGameSearchUseCase.execute(page = 1, search = keyword)) {
                is ResultCall.Success -> {
                    setState(State.ShowGame(result.data.results))
                }
                else -> setState(State.ShowError)
            }
        }
    }
}