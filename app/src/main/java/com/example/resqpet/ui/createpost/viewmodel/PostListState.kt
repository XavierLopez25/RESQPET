package com.example.resqpet.ui.createpost.viewmodel

data class PostListState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String =  ""
)
