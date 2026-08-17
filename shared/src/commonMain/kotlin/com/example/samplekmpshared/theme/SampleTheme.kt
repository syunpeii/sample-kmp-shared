package com.example.samplekmpshared.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class SampleColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color
)

data class SampleTypography(
    val titleMedium: TextStyle,
    val bodyMedium: TextStyle,
    val labelLarge: TextStyle
)

val LocalSampleColorScheme = staticCompositionLocalOf<SampleColorScheme> {
    error("No SampleColorScheme provided")
}

val LocalSampleTypography = staticCompositionLocalOf<SampleTypography> {
    error("No SampleTypography provided")
}

object SampleTheme {
    val colorScheme: SampleColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalSampleColorScheme.current

    val typography: SampleTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSampleTypography.current
}

val lightSampleColorScheme = SampleColorScheme(
    primary = Color(0xFF6750A4),
    onPrimary = Color(0xFFFFFFFF),
    background = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1C1B1F),
    surface = Color(0xFFFFFBFE),
    onSurface = Color(0xFF1C1B1F),
    secondaryContainer = Color(0xFFE8DEF8),
    onSecondaryContainer = Color(0xFF1D192B)
)

val darkSampleColorScheme = SampleColorScheme(
    primary = Color(0xFFD0BCFF),
    onPrimary = Color(0xFF381E72),
    background = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFE6E1E5),
    secondaryContainer = Color(0xFF4A4458),
    onSecondaryContainer = Color(0xFFE8DEF8)
)

val sampleTypography = SampleTypography(
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)
