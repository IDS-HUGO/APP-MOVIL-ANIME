package com.hugodev.otakuhub.features.anime.domain.repositories

import com.hugodev.otakuhub.features.anime.domain.entities.Anime

interface AnimeRepository {
    suspend fun getAnimes(): List<Anime>
}
