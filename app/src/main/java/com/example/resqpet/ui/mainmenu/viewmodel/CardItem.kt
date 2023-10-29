package com.example.resqpet.ui.mainmenu.viewmodel


data class CardItem(
    val title: String,
    val imageResId: Int,
    val animalId: Int? = null,
    val route: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val breed: String? = null,
    val sex: String? = null,
    val age: Int? = null,
    val description: String? = null,
    val personality: String? = null,
    val contactInfo: String? = null,
    val health: HealthInfo? = null,
)

data class HealthInfo(
    val isVaccinated: Boolean,
    val isCastrated: Boolean,
)