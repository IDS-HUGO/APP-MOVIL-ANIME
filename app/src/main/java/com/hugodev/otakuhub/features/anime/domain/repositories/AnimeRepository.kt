package com.hugodev.otakuhub.features.anime.domain.repositories

import com.hugodev.otakuhub.features.anime.domain.entities.Anime
import com.hugodev.otakuhub.features.anime.domain.entities.AnimeDetail

interface AnimeRepository {
    suspend fun getAnimes(): List<Anime>
    suspend fun getAnimeDetail(id: Int): AnimeDetail
}
