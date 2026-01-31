package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object SharedFavoritesViewModel {
    var favoriteIds by mutableStateOf<Set<Int>>(emptySet())

    fun toggleFavorite(animeId: Int) {
        favoriteIds = if (favoriteIds.contains(animeId)) {
            favoriteIds - animeId
        } else {
            favoriteIds + animeId
        }
    }

    fun isFavorite(animeId: Int): Boolean = favoriteIds.contains(animeId)

    fun getFavorites(): List<Int> = favoriteIds.toList()
}
