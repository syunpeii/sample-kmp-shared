package com.example.samplekmpshared.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.samplekmpshared.component.button.PrimaryButton
import com.example.samplekmpshared.component.card.ItemCard
import com.example.samplekmpshared.component.navigation.AppTopAppBar
import com.example.samplekmpshared.model.ItemCardModel
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun DetailScreen(
    model: ItemCardModel,
    onBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                title = "Detail",
                showBackButton = true,
                onBackClick = onBack,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            ItemCard(
                model = model,
                onClick = {},
            )

            PrimaryButton(
                title = "Back to previous",
                onClick = onBack,
            )
        }
    }
}

@ComponentPreview
@Composable
private fun DetailScreenPreview() {
    AppTheme {
        DetailScreen(
            model = ItemCardModel(
                id = "1",
                title = "Detail of 1",
                description = "Detailed description for item 1.",
            ),
            onBack = {},
        )
    }
}
