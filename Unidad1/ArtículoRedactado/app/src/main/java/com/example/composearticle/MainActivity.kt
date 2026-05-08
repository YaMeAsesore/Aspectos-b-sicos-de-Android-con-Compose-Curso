package com.example.composearticle


import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    var para1 = "Jetpack Compose es un toolkit moderno para construir interfaces de usuario nativas en Android. Compose simplifica y acelera el desarrollo de UI en Android con menos código, herramientas poderosas y APIs intuitivas de Kotlin."
                    var para2 = "En este tutorial, construyes un componente de UI simple con funciones declarativas. Llamas a funciones de Compose para indicar qué elementos quieres y el compilador de Compose hace el resto. Compose se basa en funciones Composables. Estas funciones te permiten definir la UI de tu app de forma programática, ya que te dejan describir cómo debe verse y proporcionar dependencias de datos, en lugar de enfocarse en el proceso de construcción de la UI, como inicializar un elemento y luego adjuntarlo a un padre. Para crear una función Composable, agrega la anotación @Composable al nombre de la función."
                    var tite = "Tutorial de Jetpack Compose"
                    Greeting(tite,para1, para2)
                }
            }
        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)

    Image(painter = image, contentDescription ="header icon" )
}
@Composable
fun TitlePart(title: String, modifier: Modifier = Modifier){
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ParagraphNo1(para: String, modifier: Modifier = Modifier ){
    Text(
        text = para,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(start=16.dp, end=16.dp)
    )
}
@Composable
fun ParagraphNo2(para: String, modifier: Modifier = Modifier){
    Text(
        text = para,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun Greeting(title: String, para1: String, para2: String, modifier: Modifier = Modifier) {


    Column(
        modifier = Modifier

    ) {
        HeaderImage(
            modifier = Modifier
                .fillMaxWidth()
        )
        TitlePart(title)
        ParagraphNo1(para1)
        ParagraphNo2(para2)
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        var para1 = "Jetpack Compose es un toolkit moderno para construir interfaces de usuario nativas en Android. Compose simplifica y acelera el desarrollo de UI en Android con menos código, herramientas poderosas y APIs intuitivas de Kotlin."
        var para2 = "En este tutorial, construyes un componente de UI simple con funciones declarativas. Llamas a funciones de Compose para indicar qué elementos quieres y el compilador de Compose hace el resto. Compose se basa en funciones Composables. Estas funciones te permiten definir la UI de tu app de forma programática, ya que te dejan describir cómo debe verse y proporcionar dependencias de datos, en lugar de enfocarse en el proceso de construcción de la UI, como inicializar un elemento y luego adjuntarlo a un padre. Para crear una función Composable, agrega la anotación @Composable al nombre de la función."
        var tite = "Tutorial de Jetpack Compose"
        Greeting(tite,para1, para2)
    }
}