package com.hugodev.otakuhub.features.anime.domain.usecases

import com.hugodev.otakuhub.features.anime.domain.entities.Anime
import com.hugodev.otakuhub.features.anime.domain.repositories.AnimeRepository

class GetAnimesUseCase(
    private val repository: AnimeRepository
) {
    suspend operator fun invoke(): Result<List<Anime>> {
        return try {
            val animes = repository.getAnimes()
            if (animes.isEmpty()) {
                Result.failure(Exception("No se encontraron animes"))
            } else {
                Result.success(animes)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}