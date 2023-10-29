package com.example.resqpet.ui.mainmenu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resqpet.R

class MainMenuViewModel: ViewModel(){
    private val _posts = MutableLiveData<List<CardItem>>()
    val posts: LiveData<List<CardItem>> get() = _posts

    private val _singlePost = MutableLiveData<CardItem?>()
    val singlePost: LiveData<CardItem?> get() = _singlePost

    fun fetchPostById(id: Int) {
        val post = posts.value?.firstOrNull { it.id == id } // Make sure this checks 'id', not 'animalId'.
        _singlePost.value = post
    }

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        val fetchedPosts = listOf(
            CardItem("Cute Cat",
                R.drawable.doggo1,
                1,
                name = "Juan",
                breed = "Bulldog",
                sex="Male",
                age = 2,
                description = "Friendly and active",
                personality = "Loyal, energetic, playful",
                contactInfo = "info@rescuecenter.com",
                health = HealthInfo(isVaccinated = true, isCastrated = true)),

            CardItem("Playful Dog",
                R.drawable.doggo2,
                2,
                name = "Panchito",
                breed = "Doberman",
                sex="Male",
                age = 2,
                description = "Friendly and active",
                personality = "Loyal, energetic, playful",
                contactInfo = "info@rescuecenter.com",
                health = HealthInfo(isVaccinated = true, isCastrated = true)),

            CardItem("Cute Cat",
                R.drawable.catto4,
                3,
                name = "Pelusa",
                breed = "Siamese",
                sex="Female",
                age = 2,
                description = "Friendly and active",
                personality = "Loyal, energetic, playful",
                contactInfo = "info@rescuecenter.com",
                health = HealthInfo(isVaccinated = true, isCastrated = true)),

            CardItem("Playful Dog",
                R.drawable.catto8,
                4,
                name = "Jose",
                breed = "Siamese",
                sex="Male",
                age = 2,
                description = "Friendly and active",
                personality = "Loyal, energetic, playful",
                contactInfo = "info@rescuecenter.com",
                health = HealthInfo(isVaccinated = true, isCastrated = true)),

            CardItem("Cute Cat",
                R.drawable.doggo3,
                5,
                name = "Canche",
                breed = "Bull Terrier",
                sex="Male",
                age = 2,
                description = "Friendly and active",
                personality = "Loyal, energetic, playful",
                contactInfo = "info@rescuecenter.com",
                health = HealthInfo(isVaccinated = true, isCastrated = true)),

            CardItem("Playful Dog",
                R.drawable.doggo4,
                6,
                name = "Balltze",
                breed = "Shiba Inu",
                sex="Male",
                age = 2,
                description = "Friendly and active",
                personality = "Loyal, energetic, playful",
                contactInfo = "info@rescuecenter.com",
                health = HealthInfo(isVaccinated = true, isCastrated = true))
        )
        _posts.value = fetchedPosts
    }

    fun getPostById(postId: Int): CardItem? {
        // Search for a post with a matching ID.
        return _posts.value?.firstOrNull { it.id == postId }
    }

}

/*val panchito = AnimalData(
            id = 1,
            name = "Panchito",
            breed = "Doberman",
            sex = "Male",
            age = 2,
            description = "Friendly and active",
            personality = "Loyal, energetic, playful",
            contactInfo = "info@rescuecenter.com",
            health = HealthInfo(isVaccinated = true, isCastrated = true),
            imageResId = R.drawable.doggo5

        )*/