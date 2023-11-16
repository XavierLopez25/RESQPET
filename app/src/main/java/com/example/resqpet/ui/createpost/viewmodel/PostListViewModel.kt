package com.example.resqpet.ui.createpost.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resqpet.firebase.repositories.PostRepository
import com.example.resqpet.firebase.repositories.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostListViewModel
@Inject
constructor(
    private val postRepository: PostRepository
): ViewModel() {

    private val _state: MutableState<PostListState> = mutableStateOf(PostListState())
    val state: State<PostListState> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    init {
        getPostList()
    }

    fun getPostList(){

        postRepository.getPostList().onEach {  result ->

            println(result.data)

            when(result){
                is Result.Error -> {
                    Log.d("getPost", "Error")
                    _state.value = PostListState(error = result.message ?: "Error inesperado")
                }
                is Result.Loading -> {
                    Log.d("getPost", "Loading")
                    _state.value = PostListState(isLoading = true)
                }
                is Result.Success -> {
                    Log.d("getPost", "Success")
                    _state.value = PostListState(posts = result.data ?: emptyList())
                }
            }

        }.launchIn(viewModelScope)

    }
}