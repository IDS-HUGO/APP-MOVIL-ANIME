package com.hugodev.otakuhub.features.anime.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeDetailScreen
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anime_list") {
        composable("anime_list") {
            AnimeListScreen(navController = navController)
        }
        composable("anime_detail/{id}") { backStackEntry ->
            val animeId = backStackEntry.arguments?.getString("id")?.toInt()
            animeId?.let {
                AnimeDetailScreen(animeId = it)
            }
        }
    }
}
