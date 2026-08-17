package com.example.samplekmpshared.component.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.component.card.ItemCard
import com.example.samplekmpshared.model.ItemCardModel
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun ScrollableCardList(
    items: List<ItemCardModel>,
    onItemClick: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items, key = { it.id }) { item ->
            ItemCard(
                model = item,
                onClick = { onItemClick(item.id) }
            )
        }
    }
}

@ComponentPreview
@Composable
private fun ScrollableCardListPreview() {
    AppTheme {
        ScrollableCardList(
            items = List(10) { i ->
                ItemCardModel(
                    id = i.toString(),
                    title = "Item $i",
                    description = "Description for item $i"
                )
            },
            onItemClick = {}
        )
    }
}
