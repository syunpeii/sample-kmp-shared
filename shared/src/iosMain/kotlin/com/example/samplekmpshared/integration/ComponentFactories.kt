package com.example.samplekmpshared.integration

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

class ExpandableCardController(initialExpanded: Boolean = false) {
    var expanded by mutableStateOf(initialExpanded)
}

class PulseLoadingButtonController(initialLoading: Boolean = false) {
    var loading by mutableStateOf(initialLoading)
}

class AppNavigationBarController(initialSelectedTab: AppTab = AppTab.HOME) {
    var selectedTab by mutableStateOf(initialSelectedTab)
}

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
        controller: ExpandableCardController,
        onExpandedChange: (Boolean) -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            AnimatedExpandableCard(
                title = title,
                description = description,
                expanded = controller.expanded,
                onExpandedChange = {
                    controller.expanded = it
                    onExpandedChange(it)
                }
            )
        }
    }

    fun createAnimatedExpandableCard(
        title: String,
        description: String,
        expanded: Boolean,
        onExpandedChange: (Boolean) -> Unit
    ): UIViewController = createAnimatedExpandableCard(
        title = title,
        description = description,
        controller = ExpandableCardController(expanded),
        onExpandedChange = onExpandedChange
    )

    fun createPulseLoadingButton(
        title: String,
        controller: PulseLoadingButtonController,
        onClick: () -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            PulseLoadingButton(title = title, loading = controller.loading, onClick = onClick)
        }
    }

    fun createPulseLoadingButton(
        title: String,
        loading: Boolean,
        onClick: () -> Unit
    ): UIViewController = createPulseLoadingButton(
        title = title,
        controller = PulseLoadingButtonController(loading),
        onClick = onClick
    )

    fun createAppTopAppBar(
        title: String,
        showBackButton: Boolean,
        onBackClick: () -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            AppTopAppBar(
                title = title,
                showBackButton = showBackButton,
                onBackClick = onBackClick,
                windowInsets = WindowInsets(0, 0, 0, 0)
            )
        }
    }

    fun createAppNavigationBar(
        controller: AppNavigationBarController,
        onTabSelected: (AppTab) -> Unit
    ): UIViewController = ComposeUIViewController {
        AppTheme {
            AppNavigationBar(
                selectedTab = controller.selectedTab,
                onTabSelected = {
                    controller.selectedTab = it
                    onTabSelected(it)
                },
                windowInsets = WindowInsets(0, 0, 0, 0)
            )
        }
    }

    fun createAppNavigationBar(
        selectedTab: AppTab,
        onTabSelected: (AppTab) -> Unit
    ): UIViewController = createAppNavigationBar(
        controller = AppNavigationBarController(selectedTab),
        onTabSelected = onTabSelected
    )
}
