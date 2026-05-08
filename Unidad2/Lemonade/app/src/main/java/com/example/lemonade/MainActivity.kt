package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var paso by remember { mutableStateOf(1) }
    var tapeos by remember { mutableStateOf(0) }
    var tapesNecesarios by remember { mutableStateOf((2..4).random()) }

    val imagen = when (paso) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val texto = when (paso) {
        1 -> R.string.lemon_tree_displ
        2 -> R.string.lemon_squeese_displ
        3 -> R.string.lemon_drink_displ
        else -> R.string.lemon_empty_displ
    }
    val descripcion = when (paso) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_lemon_content_description
        3 -> R.string.lemon_glass_of_lemonade_content_description
        else -> R.string.lemon_empty_glass_content_description
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imagen),
                contentDescription = stringResource(descripcion),
                modifier = Modifier
                    .size(200.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF4CAF50),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .clickable {
                        when (paso) {
                            1 -> {
                                // Seleccionar limón del árbol
                                tapeos = 0
                                tapesNecesarios = (2..4).random()
                                paso = 2
                            }
                            2 -> {
                                // Exprimir el limón
                                tapeos++
                                if (tapeos >= tapesNecesarios) {
                                    paso = 3
                                }
                            }
                            3 -> paso = 4  // Beber limonada
                            4 -> paso = 1  // Reiniciar
                        }
                    }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(texto),
                fontSize = 18.sp,
                color = Color(0xFF388E3C)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade()
    }
}