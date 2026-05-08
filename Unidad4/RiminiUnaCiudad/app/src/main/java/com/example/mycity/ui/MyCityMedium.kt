package com.example.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Datasource
import com.example.mycity.model.Category
import com.example.mycity.model.MyCityScreen
import com.example.mycity.model.UiState
import com.example.mycity.ui.screens.CategoryEntriesScreen
import com.example.mycity.ui.screens.DetailsScreen
import com.example.mycity.ui.screens.WelcomeScreen
import com.example.mycity.viewmodel.MyCityViewModel

@Composable
fun MyCityMedium(
    uiState: UiState,
    viewModel: MyCityViewModel,
    widthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Row {
        MyCityMediumNavigationRail(
            uiState = uiState,
            onClickHomeScreen = { viewModel.updateSelectedScreen(MyCityScreen.Welcome) },
            onClickCategory = { viewModel.updateSelectedCategory(it) }
        )
        when (uiState.selectedScreen) {
            MyCityScreen.Welcome -> {
                WelcomeScreen(
                    onClick = { viewModel.updateSelectedScreen(MyCityScreen.Categories) },
                    modifier = modifier.padding(4.dp)
                )
            }

            MyCityScreen.Details -> {
                BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Entries) }
                Column {
                    MyCityMediumAppBar(
                        uiState = uiState,
                        navigateUp = { viewModel.updateSelectedScreen(MyCityScreen.Entries) }
                    )
                    DetailsScreen(
                        entry = uiState.selectedEntry,
                        widthSizeClass = widthSizeClass,
                        modifier = modifier.padding(4.dp)
                    )
                }
            }

            else -> {
                BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Welcome) }
                Column {
                    MyCityMediumAppBar(
                        uiState = uiState,
                        navigateUp = { viewModel.updateSelectedScreen(MyCityScreen.Welcome) }
                    )
                    CategoryEntriesScreen(
                        entries = Datasource.getEntries(uiState.selectedCategory.id),
                        onClick = { viewModel.updateSelectedEntry(it) },
                        widthSizeClass = widthSizeClass,
                        modifier = modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MyCityMediumNavigationRail(
    uiState: UiState,
    onClickHomeScreen: () -> Unit,
    onClickCategory: (Category) -> Unit
) {
    NavigationRail(modifier = Modifier
        .padding(4.dp)
        .testTag("TAG_NAVIGATION_RAIL")) {
        NavigationRailItem(
            selected = uiState.selectedScreen == MyCityScreen.Welcome,
            onClick = { onClickHomeScreen() },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(R.string.home_category),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            modifier = Modifier.testTag("TAG_HOME_NAVIGATION_RAIL")
        )

        for (category in Datasource.getCategories()) {
            NavigationRailItem(
                selected = category == uiState.selectedCategory && uiState.selectedScreen != MyCityScreen.Welcome,
                onClick = { onClickCategory(category) },
                icon = {
                    Icon(
                        painter = painterResource(category.image),
                        contentDescription = stringResource(category.name),
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier.testTag("TAG_${stringResource(category.name).uppercase()}_NAVIGATION_RAIL")
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityMediumAppBar(uiState: UiState, navigateUp: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            when (uiState.selectedScreen) {

                MyCityScreen.Entries, MyCityScreen.Categories -> {
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
        }, modifier = Modifier.testTag("TAG_APP_BAR")
    )
}