package com.shub39.homepage.core.presentation

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AppDialog(
    onDismissRequest: () -> Unit,
    colors: CardColors = CardDefaults.cardColors(),
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Card(
            modifier = Modifier.widthIn(max = 500.dp),
            shape = MaterialTheme.shapes.extraLarge,
            colors = colors
        ) { content() }
    }
}