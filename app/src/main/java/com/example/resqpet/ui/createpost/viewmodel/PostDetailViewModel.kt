package com.example.resqpet.ui.createpost.viewmodel

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.resqpet.firebase.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel
@Inject
constructor(
    private val postRepository: PostRepository
): ViewModel() {

    private val _state: MutableState<PostDetailState> = mutableStateOf(PostDetailState())

    val state: State<PostDetailState>
        get() = _state

    fun addNewPost(id: Int, category: String, postAdoption: PostAdoption?, postEvent: PostEventHC?, image: Uri?){
        val post = Post(
            id = id,
            category = category,
            postAdopt = postAdoption,
            postEvent = postEvent,
            image = image
        )

        postRepository.addNewPost(post)
    }
}


