package com.example.resqpet.ui.editprofile.viewmodel

data class ProfileData(
    val name: String = "",
    val email: String = "",
    val pwd: String = "", // Use AndroidKeyStore or char array, pending.
    val phonenumber: String = "",
    val address: String = "",

)
