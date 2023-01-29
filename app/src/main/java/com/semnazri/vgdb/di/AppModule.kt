package com.semnazri.vgdb.di

import com.semnazri.vgdb.data.GameRemoteSource
import com.semnazri.vgdb.domain.*
import com.semnazri.vgdb.network.repository.GameRepository
import com.semnazri.vgdb.network.repository.GameRepositoryImpl
import com.semnazri.vgdb.ui.main.GameViewModel
import com.semnazri.vgdb.util.PreferencesManager
import com.semnazri.vgdb.util.createApi
import com.semnazri.vgdb.util.createOkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { createOkHttpClient() }
    single { createApi<GameRemoteSource>(get()) }
}

val repositoryModule = module {
    single<GameRepository> { GameRepositoryImpl(get()) }
}

val localCacheModule = module{
    single{PreferencesManager}
}

val domainModule = module {
    single<GetGameListUseCase> { GetGameListUseCaseImpl(get()) }
    single<GetGameSearchUseCase> { GetGameSearchUseCaseImpl(get()) }
    single<GetDetailGameUseCase> { GetDetailGameUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { GameViewModel(get(), get()) }
}
