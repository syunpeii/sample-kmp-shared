package com.example.samplekmpshared.component.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.SampleTheme
import com.example.samplekmpshared.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    title: String,
    showBackButton: Boolean,
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = SampleTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Text(
                        text = "<",
                        color = SampleTheme.colorScheme.primary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SampleTheme.colorScheme.surface,
            titleContentColor = SampleTheme.colorScheme.onSurface
        )
    )
}

@ComponentPreview
@Composable
private fun AppTopAppBarPreview() {
    AppTheme {
        AppTopAppBar(
            title = "Home",
            showBackButton = true,
            onBackClick = {}
        )
    }
}
