package com.hugodev.otakuhub.core.network

import com.hugodev.otakuhub.features.anime.data.datasources.remote.model.AnimeResponse
import com.hugodev.otakuhub.features.anime.data.datasources.remote.model.AnimeDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {

    @GET("anime")
    suspend fun getAnimes(): AnimeResponse

    @GET("anime/{id}/full")
    suspend fun getAnimeById(@Path("id") id: Int): AnimeDetailResponse
}
