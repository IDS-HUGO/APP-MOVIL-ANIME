package com.hugodev.otakuhub.core.di

import com.hugodev.otakuhub.features.anime.di.AnimeModule

interface AppContainer {
    val animeModule: AnimeModule
}
