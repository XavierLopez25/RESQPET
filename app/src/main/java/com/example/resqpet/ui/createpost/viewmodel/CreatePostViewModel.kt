package com.example.resqpet.ui.createpost.viewmodel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resqpet.R

class CreatePostViewModel: ViewModel(){

    override fun onCleared() {
        super.onCleared()
        println("ViewModel Cleared: $this")
    }

    var _posts = MutableLiveData<List<Post>>(mutableListOf())
    val posts: LiveData<List<Post>> get() = _posts


    private var _selectedImageUri = MutableLiveData<Uri>()
    val selectedImageUri: LiveData<Uri> get() = _selectedImageUri

    private var postIdCounter = 0

    fun getId(): Int{
        return postIdCounter
    }

    fun getImageUri(): Uri?{
        return selectedImageUri.value
    }

    fun saveImageUri(uri: Uri?){
        _selectedImageUri.value = uri!!

    }
    // Call this function to create a new Post with the selected image URI
    fun createNewPostWithImage(category: String, postAdopt: PostAdoption?, postEvent: PostEventHC?) {
        val newPost = Post(
            id = postIdCounter,
            category = category,
            image = selectedImageUri.value,
            postAdopt = postAdopt,
            postEvent = postEvent
        )
        addPost(newPost)
        println("New Post: $newPost")
    }

    private fun addPost(newPost: Post) {
        val currentPosts = _posts.value?.toMutableList() ?: mutableListOf()
        println(currentPosts)
        val postWithId = newPost.copy(id = postIdCounter)
        currentPosts.add(postWithId)

        // Crear una nueva lista a partir de currentPosts
        val updatedPosts = currentPosts.toList()

        // Publicar la nueva lista en el hilo principal
        _posts.value = updatedPosts

        println("Posts after adding: ${_posts.value}")
        postIdCounter++
    }

    fun fetchPosts(): LiveData<List<Post>> {
        return posts
    }

    val postData = MutableLiveData(Post(0, "", null, null, null))

    val postAdoption = MutableLiveData(PostAdoption("", "", false, false, "", "", "", "", "", false, false))

    val postEventHC = MutableLiveData(PostEventHC("", "", "", "", "", "", "", "", ""))

    fun resetFields() {
        postAdoption.value = PostAdoption("", "", false, false, "", "", "", "", "", false, false)
        postEventHC.value = PostEventHC("", "", "", "", "", "", "", "", "")
    }

}