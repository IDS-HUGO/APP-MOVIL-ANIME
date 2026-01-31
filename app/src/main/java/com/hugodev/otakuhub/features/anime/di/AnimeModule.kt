package com.hugodev.otakuhub.features.anime.di

import com.hugodev.otakuhub.core.network.AnimeApi
import com.hugodev.otakuhub.features.anime.data.repositories.AnimeRepositoryImpl
import com.hugodev.otakuhub.features.anime.domain.repositories.AnimeRepository
import com.hugodev.otakuhub.features.anime.domain.usecases.GetAnimeDetailUseCase
import com.hugodev.otakuhub.features.anime.domain.usecases.GetAnimesUseCase

interface AnimeModule {
    val getAnimesUseCase: GetAnimesUseCase
    val getAnimeDetailUseCase: GetAnimeDetailUseCase
}

class AnimeModuleImpl(
    private val api: AnimeApi
) : AnimeModule {

    override val getAnimesUseCase: GetAnimesUseCase by lazy {
        GetAnimesUseCase(animeRepository)
    }

    override val getAnimeDetailUseCase: GetAnimeDetailUseCase by lazy {
        GetAnimeDetailUseCase(animeRepository)
    }

    private val animeRepository: AnimeRepository by lazy {
        AnimeRepositoryImpl(api)
    }
}
