package com.example.resqpet.ui.createpost.viewmodel

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CreatePostViewModel: ViewModel(){

    private val db = FirebaseFirestore.getInstance()

    init{
        getData()
        viewModelScope.launch {
            postIdCounter = getLastPostId() + 1
        }
        setupPostsListener()
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel Cleared: $this")
    }

    var _posts = MutableLiveData<List<Post>>(mutableListOf())
    val posts: LiveData<List<Post>> get() = _posts


    private var _selectedImageUri = MutableLiveData<String>()
    val selectedImageUri: LiveData<String> get() = _selectedImageUri

    private var postIdCounter = 0


    fun getId(): Int{
        return postIdCounter
    }

    fun saveImageUri(uri: Uri?) {
        _selectedImageUri.value = uri.toString() // Convierte Uri a String antes de guardarlo
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
        createPostInDB(newPost)
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

    private fun createPostInDB(post: Post) {
        db.collection("Posts").document(post.id.toString()).set(post)
            .addOnSuccessListener {
                Log.d("CreatePostViewModel", "DocumentSnapshot successfully written!")
                postIdCounter++
                addPost(post)
                refreshPosts() // Añade esta línea para refrescar la lista de posts
            }
            .addOnFailureListener { e ->
                Log.d("CreatePostViewModel", "Error writing document", e)
            }
    }

    @SuppressLint("NullSafeMutableLiveData")
    private fun refreshPosts() {
        viewModelScope.launch {
            _posts.value = getDataFromFirestore()
            state.value = getDataFromFirestore()
        }
    }

    val state = mutableStateOf<List<Post>>(emptyList())

    private fun getData() {
        viewModelScope.launch {
            val fetchedData = getDataFromFirestore()
            state.value = fetchedData
            val lastPostId = getLastPostId()
            postIdCounter = lastPostId + 1
        }
    }

    suspend fun getDataFromFirestore(): List<Post> {
        val db = FirebaseFirestore.getInstance()
        var aboutList = emptyList<Post>()

        try {
            aboutList = db.collection("Posts")
                .get()
                .await()
                .map { it.toObject(Post::class.java) }
        } catch (e: FirebaseFirestoreException) {
            Log.d("Error", "get data from firestore: $e")
        }

        return aboutList
    }

    suspend fun addDataToFirestore(post: Post) {
        val db = FirebaseFirestore.getInstance()

        try {
            db.collection("About").add(post).await()
        } catch (e: FirebaseFirestoreException) {
            Log.d("Error", "add data to firestore: $e")
        }

    }

    private suspend fun getLastPostId(): Int {
        var maxId = 0 // Inicia con 0, el primer id posible
        try {
            val lastPostSnapshot = db.collection("Posts")
                .orderBy("id", Query.Direction.DESCENDING)
                .limit(1)
                .get()
                .await()

            // Si hay posts, toma el id más alto
            if (!lastPostSnapshot.isEmpty) {
                val lastPost = lastPostSnapshot.documents[0].toObject(Post::class.java)
                maxId = lastPost?.id ?: 0
            }
        } catch (e: FirebaseFirestoreException) {
            Log.e("ViewModel", "Error getting last post ID", e)
        }
        return maxId
    }

    private fun setupPostsListener() {
        db.collection("Posts").addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.e("ViewModel", "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null) {
                val postsList = snapshot.documents.mapNotNull { it.toObject(Post::class.java) }
                _posts.value = postsList
                state.value = postsList
            }
        }
    }

}