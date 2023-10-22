package com.example.resqpet.ui.mainmenu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resqpet.R

class MainMenuViewModel: ViewModel(){
    private val _posts = MutableLiveData<List<CardItem>>()
    val posts: LiveData<List<CardItem>> get() = _posts

    fun fetchPosts() {
        val fetchedPosts = listOf(
            CardItem("Cute Cat", R.drawable.doggo1),
            CardItem("Playful Dog", R.drawable.doggo2),
            CardItem("Cute Cat", R.drawable.catto4),
            CardItem("Playful Dog", R.drawable.catto8),
            CardItem("Cute Cat", R.drawable.doggo3),
            CardItem("Playful Dog", R.drawable.doggo4)
        )
        _posts.value = fetchedPosts
    }

}