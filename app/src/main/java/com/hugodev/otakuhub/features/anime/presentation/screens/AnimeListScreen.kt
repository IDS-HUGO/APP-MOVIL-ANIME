package com.hugodev.otakuhub.features.anime.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.hugodev.otakuhub.features.anime.presentation.components.AnimeItem
import com.hugodev.otakuhub.features.anime.presentation.viewmodels.AnimeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen(navController: NavController, viewModel: AnimeViewModel = viewModel()) {
    val animeState = viewModel.animeState

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("OtakuHub") })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(animeState.animes) { anime ->
                AnimeItem(anime = anime, modifier = Modifier.clickable { navController.navigate("anime_detail/${anime.id}") })
            }
        }
    }
}
