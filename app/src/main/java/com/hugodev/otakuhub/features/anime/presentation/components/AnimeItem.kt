package com.hugodev.otakuhub.features.anime.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hugodev.otakuhub.features.anime.domain.entities.Anime

@Composable
fun AnimeItem(anime: Anime) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = anime.imageUrl,
                contentDescription = anime.title,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = anime.title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = anime.synopsis)
            }
        }
    }
}
