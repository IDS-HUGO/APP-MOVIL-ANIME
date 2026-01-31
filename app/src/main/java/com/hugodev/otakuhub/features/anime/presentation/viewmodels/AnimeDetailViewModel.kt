package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugodev.otakuhub.features.anime.domain.entities.AnimeDetail
import com.hugodev.otakuhub.core.network.AnimeApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeDetailViewModel : ViewModel() {

    var animeDetail by mutableStateOf<AnimeDetail?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    var isFavorite by mutableStateOf(false)
        private set

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val animeApi by lazy {
        retrofit.create(AnimeApi::class.java)
    }

    fun obtenerDetalleAnime(id: Int) {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                val response = animeApi.getAnimeById(id)
                val remoteAnimeDetail = response.data

                animeDetail = AnimeDetail(
                    mal_id = remoteAnimeDetail.mal_id,
                    url = remoteAnimeDetail.url,
                    imageUrl = remoteAnimeDetail.images.jpg.largeImageUrl ?: "",
                    title = remoteAnimeDetail.title,
                    titleEnglish = remoteAnimeDetail.title_english,
                    titleJapanese = remoteAnimeDetail.title_japanese,
                    type = remoteAnimeDetail.type,
                    source = remoteAnimeDetail.source,
                    episodes = remoteAnimeDetail.episodes,
                    status = remoteAnimeDetail.status,
                    score = remoteAnimeDetail.score,
                    synopsis = remoteAnimeDetail.synopsis,
                    year = remoteAnimeDetail.year,
                    genres = remoteAnimeDetail.genres?.map { it.name ?: "" } ?: emptyList()
                )
                isFavorite = SharedFavoritesViewModel.isFavorite(id)
            } catch (e: Exception) {
                error = "Error: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun toggleFavorite(id: Int) {
        SharedFavoritesViewModel.toggleFavorite(id)
        isFavorite = SharedFavoritesViewModel.isFavorite(id)
    }
}
