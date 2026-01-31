package com.hugodev.otakuhub.features.anime.data.repositories

import com.hugodev.otakuhub.core.network.AnimeApi
import com.hugodev.otakuhub.features.anime.data.datasources.remote.mapper.toDomain
import com.hugodev.otakuhub.features.anime.domain.entities.Anime
import com.hugodev.otakuhub.features.anime.domain.repositories.AnimeRepository

class AnimeRepositoryImpl(
    private val api: AnimeApi
) : AnimeRepository {

    override suspend fun getAnimes(): List<Anime> {
        val response = api.getAnimes()
        return response.data.map { it.toDomain() }
    }
}
