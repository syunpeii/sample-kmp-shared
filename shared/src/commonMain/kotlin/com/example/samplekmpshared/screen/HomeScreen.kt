package com.example.samplekmpshared.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.samplekmpshared.component.button.PrimaryButton
import com.example.samplekmpshared.component.button.PulseLoadingButton
import com.example.samplekmpshared.component.card.AnimatedExpandableCard
import com.example.samplekmpshared.component.navigation.AppNavigationBar
import com.example.samplekmpshared.component.navigation.AppTopAppBar
import com.example.samplekmpshared.model.AppTab
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun HomeScreen(
    onNavigateToDetail: () -> Unit,
    onNavigateToDashboard: () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AppTopAppBar(
                title = "Home",
                showBackButton = false,
                onBackClick = {},
            )
        },
        bottomBar = {
            AppNavigationBar(
                selectedTab = AppTab.HOME,
                onTabSelected = { tab ->
                    if (tab == AppTab.DASHBOARD) onNavigateToDashboard()
                },
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
            AnimatedExpandableCard(
                title = "Expandable Card",
                description = "This is a KMP component controlled by Native state.",
                expanded = expanded,
                onExpandedChange = { expanded = it },
            )

            PulseLoadingButton(
                title = if (loading) "Stop Loading" else "Start Loading",
                loading = loading,
                onClick = { loading = !loading },
            )

            PrimaryButton(
                title = "Go to Detail",
                onClick = onNavigateToDetail,
            )
        }
    }
}

@ComponentPreview
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreen(
            onNavigateToDetail = {},
            onNavigateToDashboard = {},
        )
    }
}
