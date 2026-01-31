package com.hugodev.otakuhub.core.di

import android.content.Context
import com.hugodev.otakuhub.core.network.AnimeApi
import com.hugodev.otakuhub.features.anime.di.AnimeModule
import com.hugodev.otakuhub.features.anime.di.AnimeModuleImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val animeModule: AnimeModule
}

class AppContainerImpl(private val context: Context) : AppContainer {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val animeApi: AnimeApi by lazy {
        retrofit.create(AnimeApi::class.java)
    }

    override val animeModule: AnimeModule by lazy {
        AnimeModuleImpl(animeApi)
    }
}