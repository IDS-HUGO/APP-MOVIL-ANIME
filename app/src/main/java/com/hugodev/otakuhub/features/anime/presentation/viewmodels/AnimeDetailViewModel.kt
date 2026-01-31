package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugodev.otakuhub.features.anime.domain.entities.AnimeDetail
import com.hugodev.otakuhub.features.anime.domain.usecases.GetAnimeDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AnimeDetailViewModel(private val getAnimeDetailUseCase: GetAnimeDetailUseCase) : ViewModel() {

    private val _animeDetail = MutableStateFlow<AnimeDetail?>(null)
    val animeDetail = _animeDetail.asStateFlow()

    fun getAnimeDetail(id: Int) {
        viewModelScope.launch {
            getAnimeDetailUseCase(id).onSuccess {
                _animeDetail.value = it
            }
        }
    }
}
