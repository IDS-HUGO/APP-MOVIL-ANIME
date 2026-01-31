package com.hugodev.otakuhub.features.anime.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val data: List<AnimeData>
)

data class AnimeData(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("synopsis")
    val synopsis: String?
)

data class Images(
    @SerializedName("jpg")
    val jpg: Jpg
)

data class Jpg(
    @SerializedName("image_url")
    val imageUrl: String
)
