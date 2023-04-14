package com.example.cdgialumini.ui.home.uiState

import com.example.cdgialumini.models.Post

data class PostDetailUIState(
    val isLoading : Boolean = true,
    val message : String? = null,
    val data : Post? = null
)
