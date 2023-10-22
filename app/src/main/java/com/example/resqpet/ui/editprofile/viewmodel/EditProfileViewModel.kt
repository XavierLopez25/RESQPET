package com.example.resqpet.ui.editprofile.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class EditProfileViewModel: ViewModel() {


    private val _profileData = mutableStateOf(ProfileData())
    val profileData: State<ProfileData> = _profileData
    val isPasswordVisible = MutableStateFlow(false)


    // Funciones para actualizar los valores del perfil
    fun onNameChanged(name: String) {
        _profileData.value = _profileData.value.copy(name = name)
    }

    fun onEmailChanged(Email: String) {
        _profileData.value = _profileData.value.copy(email = Email)
    }

    fun onPwdChanged(Pwd: String) {
        _profileData.value = _profileData.value.copy(pwd = Pwd)
    }

    fun onPhoneChanged(Phone: String) {
        _profileData.value = _profileData.value.copy(phonenumber = Phone)
    }

    fun onAddressChanged(Address: String) {
        _profileData.value = _profileData.value.copy(address = Address)
    }

    fun saveProfile() {
        // Lógica para guardar el perfil
    }

    fun discardChanges(){
        //Lógica para deshacer cambios
    }

    fun togglePasswordVisibility() {
        isPasswordVisible.value = !isPasswordVisible.value
    }

}