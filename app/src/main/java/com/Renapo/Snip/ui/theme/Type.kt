package com.Renapo.Snip.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.Renapo.Snip.R


val MontserratRegular = FontFamily(Font(R.font.montserrat_regular))
val MontserratBold = FontFamily(Font(R.font.montserrat_bold))

val Typography = Typography(

    bodySmall = TextStyle(
        fontFamily = MontserratBold,
        fontSize = 25.sp,
        color = RedStrong,
        textAlign = TextAlign.Center,
        lineHeight = 25.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = MontserratBold,
        fontSize = 800.sp,
        lineHeight = 500.sp,
        letterSpacing = 100.sp,
        color = Gold,
        textAlign = TextAlign.Center

    ),
    //Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
