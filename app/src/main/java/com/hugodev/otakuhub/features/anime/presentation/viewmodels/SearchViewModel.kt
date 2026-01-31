package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugodev.otakuhub.features.anime.domain.entities.Anime
import com.hugodev.otakuhub.core.network.AnimeApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchViewModel : ViewModel() {

    var searchResults by mutableStateOf<List<Anime>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
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

    fun buscarAnimes(query: String) {
        if (query.isBlank()) {
            searchResults = emptyList()
            error = null
            return
        }

        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                val response = animeApi.getAnimes()
                val animesList = response.data
                    .filter { it.title.contains(query, ignoreCase = true) }
                    .map { animeData ->
                        Anime(
                            id = animeData.malId,
                            title = animeData.title,
                            imageUrl = animeData.images.jpg.imageUrl,
                            synopsis = animeData.synopsis ?: ""
                        )
                    }
                searchResults = animesList
            } catch (e: Exception) {
                error = "Error en la búsqueda: ${e.message}"
                searchResults = emptyList()
            } finally {
                isLoading = false
            }
        }
    }
}
