package com.semnazri.vgdb.di

import android.app.Application
import androidx.room.Room
import com.semnazri.vgdb.data.local.LikedGameLocalSource
import com.semnazri.vgdb.data.remote.GameRemoteSource
import com.semnazri.vgdb.db.CacheConstants
import com.semnazri.vgdb.db.GameDatabase
import com.semnazri.vgdb.db.repository.GameLocalRepository
import com.semnazri.vgdb.db.repository.GameLocalRepositoryImpl
import com.semnazri.vgdb.domain.remote.*
import com.semnazri.vgdb.network.repository.GameRepository
import com.semnazri.vgdb.network.repository.GameRepositoryImpl
import com.semnazri.vgdb.ui.detail.DetailGameViewModel
import com.semnazri.vgdb.ui.main.GameViewModel
import com.semnazri.vgdb.util.PreferencesManager
import com.semnazri.vgdb.util.createApi
import com.semnazri.vgdb.util.createOkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { createOkHttpClient() }
    single { createApi<GameRemoteSource>(get()) }
}

val repositoryModule = module {
    single<GameRepository> { GameRepositoryImpl(get()) }
    single<GameLocalRepository> { GameLocalRepositoryImpl(get()) }
}

val localCacheModule = module {
    single { PreferencesManager }
}

val domainModule = module {
    //Remote
    single<GetGameListUseCase> { GetGameListUseCaseImpl(get()) }
    single<GetGameSearchUseCase> { GetGameSearchUseCaseImpl(get()) }
    single<GetDetailGameUseCase> { GetDetailGameUseCaseImpl(get()) }

    //Local

}

val viewModelModule = module {
    viewModel { GameViewModel(get(), get()) }
    viewModel { DetailGameViewModel(get()) }
}

val dbModule = module {
    fun provideDataBase(application: Application): GameDatabase {
        return Room.databaseBuilder(application, GameDatabase::class.java, CacheConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: GameDatabase): LikedGameLocalSource {
        return dataBase.cachedGameDao()
    }

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}
