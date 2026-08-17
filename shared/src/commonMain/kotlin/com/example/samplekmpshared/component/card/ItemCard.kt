package com.example.samplekmpshared.component.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import com.example.samplekmpshared.theme.SampleTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.model.ItemCardModel
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun ItemCard(
    model: ItemCardModel,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = model.title,
                style = SampleTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = model.description,
                style = SampleTheme.typography.bodyMedium
            )
        }
    }
}

@ComponentPreview
@Composable
private fun ItemCardPreview() {
    AppTheme {
        ItemCard(
            model = ItemCardModel(
                id = "1",
                title = "Item Title",
                description = "Item Description"
            )
        )
    }
}
