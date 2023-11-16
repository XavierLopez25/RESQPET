package com.example.resqpet.ui.createpost.viewmodel

data class PostDetailState(
    val isLoading: Boolean = false,
    val post: Post? = null,
    val error: String = ""
)
