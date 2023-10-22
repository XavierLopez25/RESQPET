package com.example.resqpet.ui.animalprofile.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resqpet.R

class AnimalProfileViewModel: ViewModel() {

    private val _animals = MutableLiveData<List<AnimalData>>()
    val animals: LiveData<List<AnimalData>> get() = _animals

    init {
        loadSampleAnimals()
    }

    private fun loadSampleAnimals() {
        val panchito = AnimalData(
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

        )

        _animals.value = listOf(panchito)
    }

}