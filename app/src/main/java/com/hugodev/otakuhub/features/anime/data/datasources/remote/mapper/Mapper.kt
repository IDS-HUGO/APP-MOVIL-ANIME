package com.hugodev.otakuhub.features.anime.data.datasources.remote.mapper

import com.hugodev.otakuhub.features.anime.data.datasources.remote.model.AnimeData
import com.hugodev.otakuhub.features.anime.domain.entities.Anime

fun AnimeData.toDomain(): Anime {
    return Anime(
        id = malId,
        title = title,
        imageUrl = images.jpg.imageUrl,
        synopsis = synopsis ?: ""
    )
}
