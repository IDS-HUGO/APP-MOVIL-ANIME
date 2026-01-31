package com.hugodev.otakuhub.features.anime.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hugodev.otakuhub.features.anime.presentation.viewmodels.AnimeDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeDetailScreen(animeId: Int, viewModel: AnimeDetailViewModel = viewModel()) {
    val animeDetail by viewModel.animeDetail.collectAsState()

    viewModel.getAnimeDetail(animeId)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(animeDetail?.title ?: "") })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = animeDetail?.synopsis ?: "")
        }
    }
}
