package com.example.resqpet.ui.createpost.viewmodel

import android.net.Uri

data class Post(
    var id: Int = 0,
    var category: String = "",
    var postAdopt: PostAdoption? =null,
    var postEvent: PostEventHC? = null,
    var image: String? = null // Cambia Uri a String

    )

data class PostAdoption(
    var postTitle: String = "",
    var petsName: String = "",
    var male: Boolean = false,
    var female: Boolean = false,
    var breed: String = "",
    var age: String = "",
    var contactInfo: String = "",
    var postDescription: String = "",
    var petPersonality: String = "",
    var petCastrated: Boolean = false,
    var petVaccinated: Boolean = false,
)

data class PostEventHC(
    var postTitle: String = "",
    var foundationName: String = "",
    var postDescription: String = "",
    var minAge: String = "",
    var minSize: String = "",
    var eventTime: String = "",
    var eventDate: String = "",
    var eventPlace: String = "",
    var foundationContactInfo: String = "",

)
