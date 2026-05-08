package com.example.mycity.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Datasource
import com.example.mycity.model.Category
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun CategoriesScreen(
    categories: List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.FixedSize(160.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.testTag("TAG_CATEGORIES_GRID")
    ) {
        items(categories) {
            CategoryItem(category = it, onClick = onClick)
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = Modifier
            .size(160.dp)
            .clickable { onClick(category) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Icon(painter = painterResource(category.image), contentDescription = null)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(category.name),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(widthDp = 400, showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    MyCityTheme {
        CategoriesScreen(
            categories = Datasource.getCategories(),
            onClick = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}