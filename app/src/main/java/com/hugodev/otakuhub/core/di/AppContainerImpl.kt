package com.hugodev.otakuhub.core.di

import android.content.Context
import com.hugodev.otakuhub.core.network.AnimeApi
import com.hugodev.otakuhub.features.anime.di.AnimeModule
import com.hugodev.otakuhub.features.anime.di.AnimeModuleImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainerImpl(context: Context) : AppContainer {

    private val api: AnimeApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(AnimeApi::class.java)
    }

    override val animeModule: AnimeModule by lazy {
        AnimeModuleImpl(api)
    }
}
