package com.example.resqpet.firebase.repositories

import com.example.resqpet.ui.createpost.viewmodel.Post
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository
@Inject
constructor(
    private val Posts: CollectionReference,
) {

    fun addNewPost(post: Post) {
        try {
            Posts.document(post.id.toString()).set(post)

        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getPostList() : Flow<Result<List<Post>>> = flow {
        try {
            emit(Result.Loading<List<Post>>())

            val Posts = Posts.get().await().map{ document ->
                document.toObject(Post::class.java)

            }

            emit(Result.Success<List<Post>>(data = Posts))

        } catch (e: Exception){
            emit(Result.Error<List<Post>>(message = e.localizedMessage ?: "Error desconocido"))
        }
    }
}