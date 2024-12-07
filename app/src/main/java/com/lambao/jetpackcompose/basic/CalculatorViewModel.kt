package com.lambao.jetpackcompose.basic

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var input = mutableStateOf("")
        private set

    fun updateInput(input: String) {
        this.input.value = input
    }
}