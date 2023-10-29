package com.example.resqpet.ui.postlist.viewmodel

import androidx.compose.ui.res.painterResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resqpet.R


class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        loadData()
    }

    private fun loadData() {
        // Use resource IDs directly here
        val posts = listOf(
            Post(
                R.drawable.doggo6,
                "Loving Husky seeks warm home.",
                "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."
            ),
            Post(
                R.drawable.doggo6,
                "Loving Husky seeks warm home.",
                "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."
            ),
            Post(
                R.drawable.doggo6,
                "Loving Husky seeks warm home.",
                "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."
            ),
            Post(
                R.drawable.doggo6,
                "Loving Husky seeks warm home.",
                "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."
            ),
            Post(
                R.drawable.doggo6,
                "Loving Husky seeks warm home.",
                "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."
            ),
            Post(
                R.drawable.doggo6,
                "Loving Husky seeks warm home.",
                "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."
            )
        )

        _posts.value = posts

    }
}
