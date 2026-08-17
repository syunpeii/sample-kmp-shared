package com.example.samplekmpshared.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.SampleTheme
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun PrimaryButton(
    title: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = SampleTheme.colorScheme.primary,
            contentColor = SampleTheme.colorScheme.onPrimary
        )
    ) {
        Text(
            text = title,
            style = SampleTheme.typography.labelLarge
        )
    }
}

@ComponentPreview
@Composable
private fun PrimaryButtonPreview() {
    AppTheme {
        PrimaryButton(
            title = "Primary Button",
            onClick = {}
        )
    }
}
