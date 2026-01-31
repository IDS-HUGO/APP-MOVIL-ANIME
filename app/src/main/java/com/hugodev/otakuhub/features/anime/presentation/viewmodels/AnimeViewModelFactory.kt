package com.hugodev.otakuhub.features.anime.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hugodev.otakuhub.core.di.AppContainerImpl

class AnimeViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimeViewModel::class.java)) {
            val appContainer = AppContainerImpl(context)
            @Suppress("UNCHECKED_CAST")
            return AnimeViewModel(
                getAnimesUseCase = appContainer.animeModule.getAnimesUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}