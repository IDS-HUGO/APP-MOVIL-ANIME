package com.hugodev.otakuhub.features.anime.domain.usecases

import com.hugodev.otakuhub.features.anime.domain.repositories.AnimeRepository

class GetAnimeDetailUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(id: Int) = runCatching {
        repository.getAnimeDetail(id)
    }
}
