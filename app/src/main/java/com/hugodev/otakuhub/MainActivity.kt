package com.hugodev.otakuhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hugodev.otakuhub.core.ui.theme.AppTheme
import com.hugodev.otakuhub.features.anime.presentation.screens.AnimeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AppTheme {
                AnimeScreen()
            }
        }
    }
}