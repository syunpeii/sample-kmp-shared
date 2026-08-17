package com.example.samplekmpshared.preview

import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = 0x20) // Configuration.UI_MODE_NIGHT_YES
annotation class ComponentPreview
