package com.example.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.mycity.R
import com.example.mycity.data.Datasource
import com.example.mycity.model.MyCityScreen
import com.example.mycity.model.UiState
import com.example.mycity.ui.screens.CategoriesScreen
import com.example.mycity.ui.screens.CategoryEntriesScreen
import com.example.mycity.ui.screens.DetailsScreen
import com.example.mycity.ui.screens.WelcomeScreen
import com.example.mycity.viewmodel.MyCityViewModel

@Composable
fun MyCityCompact(
    uiState: UiState,
    viewModel: MyCityViewModel,
    widthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Column {
        when (uiState.selectedScreen) {
            MyCityScreen.Welcome -> {
                WelcomeScreen(
                    onClick = { viewModel.updateSelectedScreen(MyCityScreen.Categories) },
                    modifier = modifier
                )
            }

            MyCityScreen.Categories -> {
                BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Welcome) }
                MyCityCompactAppBar(
                    uiState = uiState,
                    navigateUp = { viewModel.updateSelectedScreen(MyCityScreen.Welcome) }
                )
                CategoriesScreen(
                    categories = Datasource.getCategories(),
                    onClick = { viewModel.updateSelectedCategory(it) },
                    modifier = modifier
                )
            }

            MyCityScreen.Entries -> {
                BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Categories) }
                MyCityCompactAppBar(
                    uiState = uiState,
                    navigateUp = { viewModel.updateSelectedScreen(MyCityScreen.Categories) }
                )
                CategoryEntriesScreen(
                    entries = Datasource.getEntries(uiState.selectedCategory.id),
                    onClick = { viewModel.updateSelectedEntry(it) },
                    widthSizeClass = widthSizeClass,
                    modifier = modifier
                )
            }

            MyCityScreen.Details -> {
                BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Entries) }
                MyCityCompactAppBar(
                    uiState = uiState,
                    navigateUp = { viewModel.updateSelectedScreen(MyCityScreen.Entries) }
                )
                DetailsScreen(
                    entry = uiState.selectedEntry,
                    widthSizeClass = widthSizeClass,
                    modifier = modifier
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityCompactAppBar(
    uiState: UiState,
    navigateUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            when (uiState.selectedScreen) {
                MyCityScreen.Categories -> {
                    Text(
                        text = stringResource(R.string.start_exploring),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displaySmall
                    )
                }

                MyCityScreen.Entries -> {
                    Text(
                        text = stringResource(uiState.selectedCategory.name),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displaySmall
                    )
                }

                MyCityScreen.Details -> {
                    Text(
                        text = stringResource(uiState.selectedEntry.name),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displaySmall
                    )
                }

                else -> {}
            }
        }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ), navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_up_button)
                )
            }
        },
        modifier = Modifier.fillMaxWidth().testTag("TAG_APP_BAR")
    )
}