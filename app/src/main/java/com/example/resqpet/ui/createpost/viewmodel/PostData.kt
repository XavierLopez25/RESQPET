package com.example.resqpet.ui.createpost.viewmodel

data class Post(
    var id: String,
    var category: String,
    var postAdopt: PostAdoption?,
    var postEvent: PostEventHC?

    )

data class PostAdoption(
    var postTitle: String,
    var petsName: String,
    var male: Boolean,
    var female: Boolean,
    var breed: String,
    var age: String,
    var contactInfo: String,
    var postDescription: String,
    var petPersonality: String,
    var petCastrated: Boolean,
    var petVaccinated: Boolean
)

data class PostEventHC(
    var postTitle: String,
    var foundationName: String,
    var postDescription: String,
    var minAge: String,
    var minSize: String,
    var eventTime: String,
    var eventDate: String,
    var eventPlace: String,
    var foundationContactInfo: String,
)
