package com.example.resqpet.ui.animalprofile.viewmodel

data class AnimalData(
    val id: Int,
    val name: String,
    val breed: String,
    val sex: String,
    val age: Int,
    val description: String,
    val personality: String,
    val contactInfo: String,
    val health: HealthInfo,
    val imageResId: Int, //temporal
    val imageUrl: String = "",
)

data class HealthInfo(
    val isVaccinated: Boolean,
    val isCastrated: Boolean,
)