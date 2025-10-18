package com.example.cliedomusicapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF1B0060)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val gradiente = Brush.verticalGradient(
    colors = listOf(Color(0xFF9F62DC), Color(0xFF903BEF))
)

val fondoDegradado = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFDCD7EC), // Color Superior (Oscuro o Primer color)
        Color(0xFFCEBBDE)  // Color Inferior (Negro o Segundo color)
    )
)

val morado = Color(0x79531B86)