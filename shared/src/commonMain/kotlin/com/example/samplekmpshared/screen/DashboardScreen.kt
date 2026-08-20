package com.example.samplekmpshared.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.samplekmpshared.component.list.ScrollableCardList
import com.example.samplekmpshared.component.navigation.AppNavigationBar
import com.example.samplekmpshared.component.navigation.AppTopAppBar
import com.example.samplekmpshared.model.AppTab
import com.example.samplekmpshared.model.ItemCardModel
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun DashboardScreen(
    items: List<ItemCardModel>,
    onNavigateToHome: () -> Unit,
    onNavigateToDetail: (String) -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                title = "Dashboard",
                showBackButton = false,
                onBackClick = {},
            )
        },
        bottomBar = {
            AppNavigationBar(
                selectedTab = AppTab.DASHBOARD,
                onTabSelected = { tab ->
                    if (tab == AppTab.HOME) onNavigateToHome()
                },
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            ScrollableCardList(
                items = items,
                onItemClick = onNavigateToDetail,
            )
        }
    }
}

@ComponentPreview
@Composable
private fun DashboardScreenPreview() {
    AppTheme {
        DashboardScreen(
            items = List(5) { i ->
                ItemCardModel(
                    id = i.toString(),
                    title = "Item $i",
                    description = "Description for item $i",
                )
            },
            onNavigateToHome = {},
            onNavigateToDetail = {},
        )
    }
}
