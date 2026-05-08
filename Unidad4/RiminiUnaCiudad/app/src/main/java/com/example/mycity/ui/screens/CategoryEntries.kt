package com.example.mycity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Datasource
import com.example.mycity.R
import com.example.mycity.model.Entry
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun CategoryEntriesScreen(
    entries: List<Entry>,
    onClick: (Entry) -> Unit,
    widthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier) {
    LazyColumn(
        state = rememberLazyListState(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.testTag("TAG_ENTRIES_LIST")
    ) {
        items(entries) {
            CategoryEntryItem(
                entry = it,
                onClick = onClick,
                widthSizeClass = widthSizeClass
            )
        }
    }
}

@Composable
fun CategoryEntryItem(
    entry: Entry,
    onClick: (Entry) -> Unit,
    widthSizeClass: WindowWidthSizeClass
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier
            .height(128.dp)
            .clickable { onClick(entry) }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = stringResource(entry.name),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleLarge,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(entry.rate),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_star_rate),
                        contentDescription = null
                    )
                }
                Text(
                    text = stringResource(entry.address).substringBefore(","),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            if (widthSizeClass != WindowWidthSizeClass.Expanded) {
                Image(
                    painter = painterResource(entry.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .width(128.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CategoryEntriesScreenPreview() {
    MyCityTheme {
        CategoryEntriesScreen(
            entries = Datasource.getEntries(1),
            onClick = {},
            widthSizeClass = WindowWidthSizeClass.Compact,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}