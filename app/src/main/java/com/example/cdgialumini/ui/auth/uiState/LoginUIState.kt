package com.example.cdgialumini.ui.auth.uiState

data class LoginUIState(
    val isLoading : Boolean = true,
    val message : String? = null,
    val data : String? = null
    )