package com.hugodev.otakuhub.core.network

import com.hugodev.otakuhub.features.anime.data.datasources.remote.model.AnimeResponse
import retrofit2.http.GET

interface AnimeApi {

    @GET("anime")
    suspend fun getAnimes(): AnimeResponse

}
