package com.example.a30daysapp.modal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.modal.Quotes.quotes
import com.example.a30daysapp.ui.theme._30DaysAppTheme

@Composable
fun Day(cita: Quota, modifier: Modifier = Modifier) {
    var mostrarCita by remember { mutableStateOf(false) }

    Card {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Cita del día ${cita.id}:",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = cita.nameRes),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            AnimatedVisibility(
                visible = mostrarCita,
                enter = expandHorizontally(),
                exit = shrinkHorizontally(
                    animationSpec = tween(durationMillis = 1500),
                    shrinkTowards = Alignment.End
                ) { fullWidth -> fullWidth / 4 }
            ) {
                if (mostrarCita) {
                    FullDislay(cita)
                }
            }

            if (!mostrarCita) {
                Display(cita)
            }

            Button(
                onClick = { mostrarCita = !mostrarCita },
                modifier = Modifier.padding(bottom = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (mostrarCita)
                        MaterialTheme.colorScheme.onPrimary
                    else
                        MaterialTheme.colorScheme.onError,
                    contentColor = MaterialTheme.colorScheme.primary,
                )
            ) {
                Text(
                    text = if (mostrarCita) "Ocultar cita" else "Mostrar cita",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaDia() {
    _30DaysAppTheme {
        Day(quotes[1])
    }
}