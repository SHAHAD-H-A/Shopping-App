package com.shahad.app.shoppingapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

data class AppColor(
    val primary: Color,
    val background: Color,
    val gray: Color,
    val secondary: Color
)

val LocalColorsProvider = staticCompositionLocalOf { lightAppColor()}

val MaterialTheme.appColors: AppColor
    @Composable
    @ReadOnlyComposable
    get() = LocalColorsProvider.current

fun darkAppColor(
    primary: Color = Color(0xFFEF3651),
    background: Color = Color(0xFF1E1F28),
    gray: Color = Color(0xFFABB4BD),
    secondary: Color = Color(0xFF2A2C36)
): AppColor = AppColor(
    primary = primary,
    background = background,
    gray = gray,
    secondary = secondary
)

fun lightAppColor(
    primary: Color = Color(0xFFDB3022) ,
    background: Color = Color(0xFFF9F9F9),
    gray: Color = Color(0xFF9B9B9B),
    secondary: Color = Color.White
): AppColor = AppColor(
    primary = primary,
    background = background,
    gray = gray,
    secondary = secondary
)