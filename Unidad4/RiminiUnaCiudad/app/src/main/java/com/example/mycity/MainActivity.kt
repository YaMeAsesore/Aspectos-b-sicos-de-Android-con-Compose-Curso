package com.example.mycity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.ui.MyCityCompact
import com.example.mycity.ui.MyCityExpanded
import com.example.mycity.ui.MyCityMedium
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.viewmodel.MyCityViewModel

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(activity = this)
                    MyCityApp(widthSizeClass = windowSizeClass.widthSizeClass)
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyCityApp(widthSizeClass: WindowWidthSizeClass, modifier: Modifier = Modifier) {


    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.main_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .alpha(0.10f)
                .matchParentSize()
        )
    }

    when (widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MyCityCompact(
                uiState = uiState,
                viewModel = viewModel,
                widthSizeClass = widthSizeClass,
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }

        WindowWidthSizeClass.Medium -> {
            MyCityMedium(
                uiState = uiState,
                viewModel = viewModel,
                widthSizeClass = widthSizeClass,
                modifier = modifier
                    .fillMaxSize()
                    .padding(4.dp)
            )
        }
        WindowWidthSizeClass.Expanded -> {
            MyCityExpanded(
                uiState = uiState,
                viewModel = viewModel,
                widthSizeClass = widthSizeClass,
                modifier = modifier
                    .fillMaxSize()
                    .padding(4.dp)
            )
        }

        else -> {
            MyCityCompact(
                uiState = uiState,
                viewModel = viewModel,
                widthSizeClass = widthSizeClass,
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MyCityCompactPreview() {
    MyCityTheme {
        MyCityApp(WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun MyCityMediumPreview() {
    MyCityTheme {
        MyCityApp(WindowWidthSizeClass.Medium)
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun MyCityExpandedPreview() {
    MyCityTheme {
        MyCityApp(WindowWidthSizeClass.Expanded)
    }
}