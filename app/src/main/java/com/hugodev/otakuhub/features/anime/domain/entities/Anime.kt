package com.hugodev.otakuhub.features.anime.domain.entities

data class Anime(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val synopsis: String
)
