package com.example.samplekmpshared.integration

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.example.samplekmpshared.component.button.PrimaryButton
import com.example.samplekmpshared.component.button.PulseLoadingButton
import com.example.samplekmpshared.component.card.ItemCard
import com.example.samplekmpshared.component.card.AnimatedExpandableCard
import com.example.samplekmpshared.component.list.ScrollableCardList
import com.example.samplekmpshared.component.navigation.AppTopAppBar
import com.example.samplekmpshared.component.navigation.AppNavigationBar
import com.example.samplekmpshared.model.ItemCardModel
import com.example.samplekmpshared.model.AppTab
import com.example.samplekmpshared.theme.AppTheme

object ComponentFactories {
    fun createPrimaryButton(
        title: String,
        enabled: Boolean,
        onClick: () -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            PrimaryButton(title = title, enabled = enabled, onClick = onClick)
        }
    }

    fun createItemCard(
        id: String,
        title: String,
        description: String,
        onClick: () -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            ItemCard(
                model = ItemCardModel(id = id, title = title, description = description),
                onClick = onClick
            )
        }
    }

    fun createScrollableCardList(
        items: List<ItemCardModel>,
        onItemClick: (String) -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            ScrollableCardList(items = items, onItemClick = onItemClick)
        }
    }

    fun createAnimatedExpandableCard(
        title: String,
        description: String,
        expanded: Boolean,
        onExpandedChange: (Boolean) -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            AnimatedExpandableCard(
                title = title,
                description = description,
                expanded = expanded,
                onExpandedChange = onExpandedChange
            )
        }
    }

    fun createPulseLoadingButton(
        title: String,
        loading: Boolean,
        onClick: () -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            PulseLoadingButton(title = title, loading = loading, onClick = onClick)
        }
    }

    fun createAppTopAppBar(
        title: String,
        showBackButton: Boolean,
        onBackClick: () -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            AppTopAppBar(title = title, showBackButton = showBackButton, onBackClick = onBackClick)
        }
    }

    fun createAppNavigationBar(
        selectedTab: AppTab,
        onTabSelected: (AppTab) -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            AppNavigationBar(selectedTab = selectedTab, onTabSelected = onTabSelected)
        }
    }
}
