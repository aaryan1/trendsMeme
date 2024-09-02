package com.tks.trendsmeme.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> SingleSelectDialog(
    options: List<T>,
    selectedOption: T?,
    onOptionSelected: (T) -> Unit,
    onDismiss: () -> Unit,
) {
    var selectedIndex by remember {
        mutableStateOf(
            options.indexOf(selectedOption)
        )
    }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select an option") },
        text = {
            Column {
                options.forEachIndexed { index, option ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (index == selectedIndex),
                                onClick = {
                                    selectedIndex = index
                                    onOptionSelected(option)
                                }
                            )
                            .padding(16.dp)
                    ) {
                        RadioButton(
                            selected = (index == selectedIndex),
                            onClick = null
                        )
                        Text(
                            text = option.toString(),
                            style = MaterialTheme.typography.bodyMedium.merge(),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}