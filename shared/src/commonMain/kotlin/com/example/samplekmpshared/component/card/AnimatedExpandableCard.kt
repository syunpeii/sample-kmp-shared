package com.example.samplekmpshared.component.card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import com.example.samplekmpshared.theme.SampleTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun AnimatedExpandableCard(
    title: String,
    description: String,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize()
            .clickable { onExpandedChange(!expanded) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = SampleTheme.typography.titleMedium
            )
            AnimatedVisibility(visible = expanded) {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = description,
                        style = SampleTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@ComponentPreview
@Composable
private fun AnimatedExpandableCardPreview() {
    AppTheme {
        AnimatedExpandableCard(
            title = "Expandable Card",
            description = "This is a detailed description that appears when the card is expanded.",
            expanded = false,
            onExpandedChange = {}
        )
    }
}

@ComponentPreview
@Composable
private fun AnimatedExpandableCardExpandedPreview() {
    AppTheme {
        AnimatedExpandableCard(
            title = "Expandable Card",
            description = "This is a detailed description that appears when the card is expanded.",
            expanded = true,
            onExpandedChange = {}
        )
    }
}
