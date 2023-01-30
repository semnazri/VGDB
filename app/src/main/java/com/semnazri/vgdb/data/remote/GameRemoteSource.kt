package com.semnazri.vgdb.data.remote

import com.semnazri.vgdb.BuildConfig
import com.semnazri.vgdb.model.details.GameDetailResponse
import com.semnazri.vgdb.model.list.GameListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameRemoteSource {

    @GET("games")
    suspend fun getGameList(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int,
        @Query("pageSize") size: Int = 50
    ): Response<GameListResponse>

    @GET("games")
    suspend fun searchGame(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("search") searchKey: String,
        @Query("page") page: Int,
        @Query("pageSize") size: Int = 10
    ): Response<GameListResponse>

    @GET("games/{id}")
    suspend fun getGameDetail(
        @Path("id", encoded = true) id: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Response<GameDetailResponse>


}