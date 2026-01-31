package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugodev.otakuhub.features.anime.domain.usecases.GetAnimesUseCase
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeState
import kotlinx.coroutines.launch

class AnimeViewModel(
    private val getAnimesUseCase: GetAnimesUseCase
) : ViewModel() {

    var animeState by mutableStateOf(AnimeState())
        private set

    init {
        getAnimes()
    }

    private fun getAnimes() {
        viewModelScope.launch {
            animeState = animeState.copy(isLoading = true)

            getAnimesUseCase().onSuccess { animes ->
                animeState = animeState.copy(
                    animes = animes,
                    isLoading = false,
                    error = null
                )
            }.onFailure { e ->
                animeState = animeState.copy(
                    error = e.message ?: "Error desconocido",
                    isLoading = false
                )
            }
        }
    }

    fun retry() {
        getAnimes()
    }
}