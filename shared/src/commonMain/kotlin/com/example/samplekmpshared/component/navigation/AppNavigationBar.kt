package com.example.samplekmpshared.component.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.model.AppTab
import com.example.samplekmpshared.theme.SampleTheme
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun AppNavigationBar(
    selectedTab: AppTab,
    onTabSelected: (AppTab) -> Unit,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
) {
    NavigationBar(
        containerColor = SampleTheme.colorScheme.surface,
        contentColor = SampleTheme.colorScheme.onSurface,
        windowInsets = windowInsets
    ) {
        AppTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                icon = {
                    Text(
                        text = if (tab == AppTab.HOME) "H" else "D",
                        style = SampleTheme.typography.bodyMedium,
                        color = if (selectedTab == tab) SampleTheme.colorScheme.primary else SampleTheme.colorScheme.onSurface
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        style = SampleTheme.typography.labelLarge
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = SampleTheme.colorScheme.primary,
                    unselectedIconColor = SampleTheme.colorScheme.onSurface,
                    selectedTextColor = SampleTheme.colorScheme.primary,
                    unselectedTextColor = SampleTheme.colorScheme.onSurface,
                    indicatorColor = SampleTheme.colorScheme.secondaryContainer
                )
            )
        }
    }
}

@ComponentPreview
@Composable
private fun AppNavigationBarPreview() {
    AppTheme {
        AppNavigationBar(
            selectedTab = AppTab.HOME,
            onTabSelected = {}
        )
    }
}
