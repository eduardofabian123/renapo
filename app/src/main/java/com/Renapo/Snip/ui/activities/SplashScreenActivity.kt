package com.Renapo.Snip.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.EaseOutExpo
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.lerp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Renapo.Snip.R
import com.Renapo.Snip.ui.theme.MontserratBold
import com.Renapo.Snip.ui.theme.MontserratRegular
import com.Renapo.Snip.ui.theme.RedStrong
import com.Renapo.Snip.ui.theme.RenapoSnipTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RenapoSnipTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary,
                ) {
                    SplashScreen()

                }
            }
        }
    }
}



@Preview
@Composable
fun SplashScreen() {
    Box(modifier = Modifier.fillMaxSize() ){
        Image(
            painter = painterResource(id = R.drawable.background_splash_screen),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.padding(start = 25.dp, end = 25.dp),
                    painter = painterResource(id = R.drawable.ic_logo_gobernation),
                    contentDescription = null
                )
        }
    }
    Box(modifier = Modifier.fillMaxSize() ){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            val textWriter = TypewriterTextComponent(
                texts = listOf(stringResource(
                    id = R.string.abbreviation_meaning_snip)))
            ScaleTextComponent(textWriter = textWriter)
        }
    }
}
@Composable
fun TypewriterTextComponent(
    texts: List<String>,
) : String{
    var textIndex by remember { mutableStateOf(0) }
    var textToDisplay by remember { mutableStateOf("") }
    LaunchedEffect(
        key1 = texts,
    ) {
        while (textIndex < texts.size) {
            texts[textIndex].forEachIndexed { charIndex, _ ->
                textToDisplay = texts[textIndex]
                    .substring(
                        startIndex = 0,
                        endIndex = charIndex + 1,
                    )
                delay(48)
            }
            textIndex = texts.size
        }
    }
    return textToDisplay
}

@Composable
fun ScaleTextComponent(textWriter:String){

    val coroutineScope = rememberCoroutineScope()

    val animation = remember { Animatable(0f) }

    val h1 = MaterialTheme.typography.bodySmall
    val h2 = MaterialTheme.typography.bodyLarge

    val textStyle by remember(animation.value) {
        derivedStateOf { lerp(h1, h2, animation.value) }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = textWriter,
                style = textStyle,
                modifier = Modifier.padding(top = 40.dp)
            )

            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    animation.animateTo(1f, tween(900,4200  ))
                }
            }
        }
    }
}


