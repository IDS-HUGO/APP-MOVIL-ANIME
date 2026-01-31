package com.hugodev.otakuhub.features.anime.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeDetailScreen
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeScreen
import com.hugodev.otakuhub.features.anime.presentation.screens.FavoritesScreen
import com.hugodev.otakuhub.features.anime.presentation.screens.ProfileScreen
import com.hugodev.otakuhub.features.anime.presentation.screens.SearchScreen

sealed class NavRoute(val route: String, val label: String) {
    object Home : NavRoute("home", "Inicio")
    object Search : NavRoute("search", "Buscar")
    object Favorites : NavRoute("favorites", "Favoritos")
    object Profile : NavRoute("profile", "Perfil")
    object Detail : NavRoute("detail/{id}", "Detalles")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var currentRoute by remember { mutableStateOf(NavRoute.Home.route) }

    Scaffold(
        bottomBar = {
            if (currentRoute != NavRoute.Detail.route && !currentRoute.contains("detail")) {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
                        label = { Text("Inicio") },
                        selected = currentRoute == NavRoute.Home.route,
                        onClick = {
                            if (currentRoute != NavRoute.Home.route) {
                                navController.navigate(NavRoute.Home.route) {
                                    popUpTo(NavRoute.Home.route) { inclusive = true }
                                }
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Search, contentDescription = "Buscar") },
                        label = { Text("Buscar") },
                        selected = currentRoute == NavRoute.Search.route,
                        onClick = {
                            if (currentRoute != NavRoute.Search.route) {
                                navController.navigate(NavRoute.Search.route) {
                                    popUpTo(NavRoute.Search.route) { inclusive = true }
                                }
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favoritos") },
                        label = { Text("Favoritos") },
                        selected = currentRoute == NavRoute.Favorites.route,
                        onClick = {
                            if (currentRoute != NavRoute.Favorites.route) {
                                navController.navigate(NavRoute.Favorites.route) {
                                    popUpTo(NavRoute.Favorites.route) { inclusive = true }
                                }
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
                        label = { Text("Perfil") },
                        selected = currentRoute == NavRoute.Profile.route,
                        onClick = {
                            if (currentRoute != NavRoute.Profile.route) {
                                navController.navigate(NavRoute.Profile.route) {
                                    popUpTo(NavRoute.Profile.route) { inclusive = true }
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavRoute.Home.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(NavRoute.Home.route) {
                currentRoute = NavRoute.Home.route
                AnimeScreen(
                    navController = navController,
                    contentPadding = paddingValues
                )
            }
            composable(NavRoute.Search.route) {
                currentRoute = NavRoute.Search.route
                SearchScreen(contentPadding = paddingValues)
            }
            composable(NavRoute.Favorites.route) {
                currentRoute = NavRoute.Favorites.route
                FavoritesScreen(
                    navController = navController,
                    contentPadding = paddingValues
                )
            }
            composable(NavRoute.Profile.route) {
                currentRoute = NavRoute.Profile.route
                ProfileScreen(contentPadding = paddingValues)
            }
            composable("detail/{animeId}") { backStackEntry ->
                currentRoute = "detail/${backStackEntry.arguments?.getString("animeId")}"
                val animeId = backStackEntry.arguments?.getString("animeId")?.toInt() ?: 0
                AnimeDetailScreen(
                    animeId = animeId,
                    navController = navController,
                    contentPadding = paddingValues
                )
            }
        }
    }
}
