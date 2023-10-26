package com.ostapenko.keystonecompanion.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = primaryBlack,
    secondary = primaryOrange,
    background = primaryBlack,
    surface = primaryWhite,
    onPrimary = primaryWhite,
    onSecondary = primaryBlack,
    onBackground = primaryWhite,
    onSurface = primaryBlack
)

private val DarkColorPalette = darkColors(
    primary = primaryBlack,
    secondary = primaryOrange,
    background = primaryBlack,
    surface = primaryWhite,
    onPrimary = primaryWhite,
    onSecondary = primaryBlack,
    onBackground = primaryWhite,
    onSurface = primaryBlack
)

@Composable
fun MyKeystoneTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}