package com.example.samplekmpshared.component.button

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.samplekmpshared.preview.ComponentPreview
import com.example.samplekmpshared.theme.SampleTheme
import com.example.samplekmpshared.theme.AppTheme

@Composable
fun PulseLoadingButton(
    title: String,
    loading: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = !loading,
        colors = ButtonDefaults.buttonColors(
            containerColor = SampleTheme.colorScheme.primary,
            contentColor = SampleTheme.colorScheme.onPrimary
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (loading) {
                val infiniteTransition = rememberInfiniteTransition()
                val scale by infiniteTransition.animateFloat(
                    initialValue = 1f,
                    targetValue = 1.2f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(1000),
                        repeatMode = RepeatMode.Reverse
                    )
                )
                val alpha by infiniteTransition.animateFloat(
                    initialValue = 1f,
                    targetValue = 0.5f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(1000),
                        repeatMode = RepeatMode.Reverse
                    )
                )

                CircularProgressIndicator(
                    modifier = Modifier
                        .size(24.dp)
                        .scale(scale)
                        .alpha(alpha),
                    strokeWidth = 2.dp,
                    color = SampleTheme.colorScheme.onPrimary
                )
            } else {
                Text(
                    text = title,
                    style = SampleTheme.typography.labelLarge
                )
            }
        }
    }
}

@ComponentPreview
@Composable
private fun PulseLoadingButtonPreview() {
    AppTheme {
        PulseLoadingButton(
            title = "Pulse Loading Button",
            loading = false,
            onClick = {}
        )
    }
}

@ComponentPreview
@Composable
private fun PulseLoadingButtonLoadingPreview() {
    AppTheme {
        PulseLoadingButton(
            title = "Pulse Loading Button",
            loading = true,
            onClick = {}
        )
    }
}
