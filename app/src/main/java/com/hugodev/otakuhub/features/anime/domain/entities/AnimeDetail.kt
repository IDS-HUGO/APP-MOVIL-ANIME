package com.hugodev.otakuhub.features.anime.domain.entities

data class AnimeDetail(
    val mal_id: Int,
    val url: String,
    val imageUrl: String,
    val title: String,
    val titleEnglish: String?,
    val titleJapanese: String?,
    val type: String?,
    val source: String?,
    val episodes: Int?,
    val status: String?,
    val score: Double?,
    val synopsis: String?,
    val year: Int?,
    val genres: List<String>?
)
