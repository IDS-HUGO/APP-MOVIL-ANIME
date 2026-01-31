package com.hugodev.otakuhub.features.anime.data.datasources.remote.mapper

import com.hugodev.otakuhub.features.anime.data.datasources.remote.model.AnimeDetail
import com.hugodev.otakuhub.features.anime.domain.entities.AnimeDetail as AnimeDetailDomain

fun AnimeDetail.toDomain(): AnimeDetailDomain {
    return AnimeDetailDomain(
        mal_id = mal_id,
        url = url,
        imageUrl = images.jpg.largeImageUrl ?: "",
        title = title,
        titleEnglish = title_english,
        titleJapanese = title_japanese,
        type = type,
        source = source,
        episodes = episodes,
        status = status,
        score = score,
        synopsis = synopsis,
        year = year,
        genres = genres?.map { it.name ?: "" } ?: emptyList()
    )
}