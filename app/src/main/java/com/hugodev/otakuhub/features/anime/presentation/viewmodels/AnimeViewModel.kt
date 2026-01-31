package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugodev.otakuhub.features.anime.domain.usecases.GetAnimesUseCase
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimeViewModel(
    private val getAnimesUseCase: GetAnimesUseCase
) : ViewModel() {

    private val _animeState = MutableStateFlow(AnimeState())
    val animeState: StateFlow<AnimeState> = _animeState

    init {
        getAnimes()
    }

    private fun getAnimes() {
        viewModelScope.launch {
            _animeState.value = _animeState.value.copy(isLoading = true)
            getAnimesUseCase().onSuccess { animes ->
                _animeState.value = _animeState.value.copy(
                    animes = animes,
                    isLoading = false
                )
            }.onFailure { e ->
                _animeState.value = _animeState.value.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }
}