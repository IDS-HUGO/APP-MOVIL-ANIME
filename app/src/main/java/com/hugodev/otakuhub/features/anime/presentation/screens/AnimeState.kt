package com.hugodev.otakuhub.features.anime.presentation.screens

import com.hugodev.otakuhub.features.anime.domain.entities.Anime

data class AnimeState(
    val animes: List<Anime> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)