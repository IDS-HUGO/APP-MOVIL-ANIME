package com.hugodev.otakuhub.features.anime.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(
    @SerializedName("data")
    val data: AnimeDetail
)

data class AnimeDetail(
    val mal_id: Int,
    val url: String,
    val images: ImagesDetail,
    val title: String,
    val title_english: String?,
    val title_japanese: String?,
    val type: String?,
    val source: String?,
    val episodes: Int?,
    val status: String?,
    val airing: Boolean?,
    val aired: Aired?,
    val duration: String?,
    val rating: String?,
    val score: Double?,
    val scored_by: Int?,
    val rank: Int?,
    val popularity: Int?,
    val members: Int?,
    val favorites: Int?,
    val synopsis: String?,
    val background: String?,
    val season: String?,
    val year: Int?,
    val broadcast: Broadcast?,
    val producers: List<Genre>?,
    val licensors: List<Genre>?,
    val studios: List<Genre>?,
    val genres: List<Genre>?,
    val themes: List<Genre>?,
    val demographics: List<Genre>?,
    val relations: List<Relation>?,
    val theme: Theme?,
    val external: List<External>?,
    val streaming: List<Streaming>?
)

data class Aired(
    val from: String?,
    val to: String?,
    val prop: Prop?
)

data class Broadcast(
    val day: String?,
    val time: String?,
    val timezone: String?,
    val string: String?
)

data class Genre(
    val mal_id: Int?,
    val type: String?,
    val name: String?,
    val url: String?
)

data class Relation(
    val relation: String?,
    val entry: List<Entry>?
)

data class Entry(
    val mal_id: Int?,
    val type: String?,
    val name: String?,
    val url: String?
)

data class Theme(
    val openings: List<String>?,
    val endings: List<String>?
)

data class External(
    val name: String?,
    val url: String?
)

data class Streaming(
    val name: String?,
    val url: String?
)

data class Prop(
    val from: DayMonthYear?,
    val to: DayMonthYear?
)

data class DayMonthYear(
    val day: Int?,
    val month: Int?,
    val year: Int?
)

data class ImagesDetail(
    @SerializedName("jpg")
    val jpg: JpgDetail
)

data class JpgDetail(
    @SerializedName("large_image_url")
    val largeImageUrl: String?
)

