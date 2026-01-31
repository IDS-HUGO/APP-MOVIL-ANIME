package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AnimeViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AnimeViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                AnimeViewModel() as T
            }
            modelClass.isAssignableFrom(AnimeDetailViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                AnimeDetailViewModel() as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}

