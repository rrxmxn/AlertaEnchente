package com.example.alertaenchente.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary,
    background = BackgroundDark,
    surface = SurfaceDark,
    error = Error,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary,
    onBackground = OnBackgroundDark,
    onSurface = OnSurfaceDark,
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary,
    background = BackgroundLight,
    surface = SurfaceLight,
    error = Error,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary,
    onBackground = OnBackgroundLight,
    onSurface = OnSurfaceLight,
)

@Composable
fun AlertaEnchenteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}
