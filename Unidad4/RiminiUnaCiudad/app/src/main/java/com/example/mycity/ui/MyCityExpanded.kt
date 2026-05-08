package com.example.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Datasource
import com.example.mycity.model.MyCityScreen
import com.example.mycity.model.UiState
import com.example.mycity.ui.screens.CategoryEntriesScreen
import com.example.mycity.ui.screens.DetailsScreen
import com.example.mycity.ui.screens.WelcomeScreen
import com.example.mycity.viewmodel.MyCityViewModel

@Composable
fun MyCityExpanded(
    uiState: UiState,
    viewModel: MyCityViewModel,
    widthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    PermanentNavigationDrawer(drawerContent = {
        PermanentDrawerSheet(modifier = Modifier.width(256.dp)) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.my_city_logo),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
                NavigationDrawerItem(
                    label = {
                        Text(text = stringResource(R.string.home_category))
                    },
                    selected = uiState.selectedScreen == MyCityScreen.Welcome,
                    onClick = { viewModel.updateSelectedScreen(MyCityScreen.Welcome) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = stringResource(R.string.home_category),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    modifier = Modifier.testTag("TAG_HOME_NAVIGATION_DRAWER")
                )

                for (category in Datasource.getCategories()) {
                    NavigationDrawerItem(
                        label = {
                            Text(text = stringResource(category.name))
                        },
                        selected = uiState.selectedCategory == category && uiState.selectedScreen != MyCityScreen.Welcome,
                        onClick = { viewModel.updateSelectedCategory(category) },
                        icon = {
                            Icon(
                                painter = painterResource(category.image),
                                contentDescription = stringResource(category.name),
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        modifier = Modifier.testTag("TAG_${stringResource(category.name).uppercase()}_NAVIGATION_DRAWER")
                    )
                }
            }
        }
    }, modifier = modifier.padding(4.dp).testTag("TAG_NAVIGATION_DRAWER")) {
        if (uiState.selectedScreen == MyCityScreen.Welcome) {
            WelcomeScreen(
                onClick = { viewModel.updateSelectedScreen(MyCityScreen.Categories) },
                modifier = modifier.padding(4.dp)
            )
        } else {
            BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Welcome) }
            Row {
                CategoryEntriesScreen(
                    entries = Datasource.getEntries(uiState.selectedCategory.id),
                    onClick = { viewModel.updateSelectedEntry(it) },
                    widthSizeClass = widthSizeClass,
                    modifier = Modifier
                        .weight(2f)
                        .padding(4.dp)
                )
                DetailsScreen(
                    entry = uiState.selectedEntry,
                    widthSizeClass = widthSizeClass,
                    modifier = Modifier
                        .weight(3f)
                        .padding(4.dp)
                )
            }
        }
    }
}