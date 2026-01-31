package com.hugodev.otakuhub.features.anime.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.hugodev.otakuhub.features.anime.presentation.viewmodels.AnimeDetailViewModel
import com.hugodev.otakuhub.features.anime.presentation.viewmodels.AnimeViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeDetailScreen(
    animeId: Int,
    navController: NavController? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    viewModel: AnimeDetailViewModel = viewModel(factory = AnimeViewModelFactory())
) {
    val animeDetail = viewModel.animeDetail
    val isLoading = viewModel.isLoading
    val error = viewModel.error
    val isFavorite = viewModel.isFavorite

    LaunchedEffect(animeId) {
        viewModel.obtenerDetalleAnime(animeId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(animeDetail?.title ?: "Detalles del Anime") },
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.toggleFavorite(animeId) }) {
                        Icon(
                            if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).padding(contentPadding).fillMaxWidth()) {
            when {
                isLoading -> {
                    Box(modifier = Modifier.padding(16.dp)) {
                        CircularProgressIndicator()
                    }
                }
                error != null -> {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Error: $error")
                    }
                }
                animeDetail != null -> {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Título: ${animeDetail.title}", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(8.dp))
                        Text("Tipo: ${animeDetail.type ?: "No especificado"}", modifier = Modifier.padding(8.dp))
                        Text("Puntuación: ${animeDetail.score ?: "N/A"}/10", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(8.dp))
                        Text("Episodios: ${animeDetail.episodes ?: "Desconocido"}", modifier = Modifier.padding(8.dp))
                        Text("Estado: ${animeDetail.status ?: "Desconocido"}", modifier = Modifier.padding(8.dp))
                        Text("Sinopsis: ${animeDetail.synopsis ?: "No disponible"}", modifier = Modifier.padding(8.dp))
                    }
                }
                else -> {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Sin información disponible")
                    }
                }
            }
        }
    }
}
