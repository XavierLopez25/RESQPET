package com.example.resqpet.ui.petlist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.resqpet.R

class PetListViewModel: ViewModel(){
    var pets: List<Pet> by mutableStateOf(listOf())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        pets = listOf(
            Pet(R.drawable.doggo3, "Cookie", "3 años", "Hembra", "Husky"),
            Pet(R.drawable.catto5, "Luna", "2 años", "Hembra", "Persa"),
            Pet(R.drawable.doggo4, "Balltze", "1 año", "Macho", "Shiba Inu"),
            Pet(R.drawable.catto6, "Mechs", "4 años", "Macho", "Siamés")
        )
    }

}