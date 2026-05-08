package com.example.mycity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycity.R

val Dosis = FontFamily(
    Font(R.font.dosis_extralight, FontWeight.ExtraLight),
    Font(R.font.dosis_regular, FontWeight.Normal),
    Font(R.font.dosis_bold, FontWeight.Bold)
)


val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 16.sp
    )

)