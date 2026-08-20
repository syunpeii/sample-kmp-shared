package com.example.samplekmpshared.integration

import androidx.compose.ui.window.ComposeUIViewController
import com.example.samplekmpshared.model.ItemCardModel
import com.example.samplekmpshared.screen.DashboardScreen
import com.example.samplekmpshared.screen.DetailScreen
import com.example.samplekmpshared.screen.HomeScreen
import com.example.samplekmpshared.theme.AppTheme
import platform.UIKit.UIViewController

object ScreenFactories {
    fun createHomeScreen(
        onNavigateToDetail: () -> Unit,
        onNavigateToDashboard: () -> Unit,
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            HomeScreen(
                onNavigateToDetail = onNavigateToDetail,
                onNavigateToDashboard = onNavigateToDashboard,
            )
        }
    }

    fun createDashboardScreen(
        items: List<ItemCardModel>,
        onNavigateToHome: () -> Unit,
        onNavigateToDetail: (String) -> Unit,
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            DashboardScreen(
                items = items,
                onNavigateToHome = onNavigateToHome,
                onNavigateToDetail = onNavigateToDetail,
            )
        }
    }

    fun createDetailScreen(
        itemId: String,
        title: String,
        description: String,
        onBack: () -> Unit,
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            DetailScreen(
                model = ItemCardModel(
                    id = itemId,
                    title = title,
                    description = description,
                ),
                onBack = onBack,
            )
        }
    }

    fun createDetailScreen(
        model: ItemCardModel,
        onBack: () -> Unit,
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            DetailScreen(
                model = model,
                onBack = onBack,
            )
        }
    }
}
