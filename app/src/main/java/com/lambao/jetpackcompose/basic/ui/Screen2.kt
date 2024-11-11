package com.lambao.jetpackcompose.basic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PlatformImeOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val text = remember { mutableStateOf("") }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()
    val isDragged = interactionSource.collectIsDraggedAsState()
    val isFocused = interactionSource.collectIsFocusedAsState()
    val isHovered = interactionSource.collectIsHoveredAsState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            "Sign In",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            fontSize = 24.sp
        )
        Text(
            "Enter your emails and password",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black,
            fontSize = 16.sp
        )

        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            readOnly = false,
            textStyle = MaterialTheme.typography.bodyMedium, // set style of text
            label = {
                Text(
                    "Email",
                    style = MaterialTheme.typography.labelLarge
                )
            },
            /* Custom text of label*/
            placeholder = {
                Text(
                    "Enter email",
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            /* Custom text of placeholder*/
            leadingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_dialog_email),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                    contentDescription = null
                )
            },
            /*prefix = { Text(text = "Prefix") },*/
            /*suffix = { Text(text = "Suffix") },*/
            supportingText = {
                Text(text = "Supporting text")
            },
            isError = true,
            /* visualTransformation = PasswordVisualTransformation(),*/
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.None,
                platformImeOptions = PlatformImeOptions(
                    privateImeOptions = "asd",
                )
            ),
            keyboardActions = KeyboardActions(
                onDone = { /*TODO*/ },
                onGo = { /*TODO*/ },
                onNext = { /*TODO*/ },
                onPrevious = { /*TODO*/ },
                onSearch = { /*TODO*/ },
                onSend = { /*TODO*/ },
            ),
            singleLine = false,
            maxLines = 3,
            minLines = 2,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            when (it) {
                                is PressInteraction.Press -> {
                                    // works like onClick
                                }

                                is PressInteraction.Release -> {
                                    // works like onClick
                                }

                                is PressInteraction.Cancel -> {
                                    // works like onClick
                                    // or onLongClick
                                }
                            }
                        }
                    }
                },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Gray,
                focusedIndicatorColor = Color.Transparent, // Hide the indicator
                unfocusedIndicatorColor = Color.Transparent,
                disabledTextColor = Color.LightGray,
                errorCursorColor = Color.Red,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Magenta,
                // ... other color properties
            )
        )
    }
}