package com.example.resqpet.ui.editprofile.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resqpet.ui.register.viewmodel.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class EditProfileViewModel: ViewModel() {


    private val _profileData = mutableStateOf(User())
    val profileData: State<User> = _profileData
    val isPasswordVisible = MutableStateFlow(false)

    private val auth = FirebaseAuth.getInstance()

    private fun getCurrentUserEmail(): String? {
        return auth.currentUser?.email
    }

    fun fetchUserProfile() {
        val userEmail = getCurrentUserEmail() ?: return

        viewModelScope.launch {
            val userProfile = FirebaseFirestore.getInstance()
                .collection("Users")
                .document(userEmail)
                .get()
                .await()
                .toObject(User::class.java)

            onNameChanged(userProfile!!.username)
            onCompleteNameChanged(userProfile.completeName)
            onEmailChanged(userProfile.email)
            onPwdChanged(userProfile.password)
            onProfilePhotoChanged(userProfile.profilePhoto)


        }
    }

    private var _selectedImageUri = MutableLiveData<String>()
    val selectedImageUri: LiveData<String> get() = _selectedImageUri
    fun saveImageUri(uri: Uri?) {
        _selectedImageUri.value = uri.toString() // Convierte Uri a String antes de guardarlo
    }

    // Funciones para actualizar los valores del perfil
    fun onNameChanged(name: String) {
        _profileData.value = _profileData.value.copy(username = name)
    }

    fun onCompleteNameChanged(completeName: String) {
        _profileData.value = _profileData.value.copy(completeName = completeName)
    }

    fun onEmailChanged(Email: String) {
        _profileData.value = _profileData.value.copy(email = Email)
    }

    fun onPwdChanged(Pwd: String) {
        _profileData.value = _profileData.value.copy(password = Pwd)
    }

    fun onProfilePhotoChanged(photoUrl: String?) {
        _selectedImageUri.value = photoUrl ?: ""
    }

    fun saveProfile() {
        // When saving the profile, also update the profile photo URL in Firebase
        val userEmail = getCurrentUserEmail() ?: return
        val userUpdates = hashMapOf<String, Any>(
            "username" to _profileData.value.username,
            "completeName" to _profileData.value.completeName,
            "email" to _profileData.value.email,
            "password" to _profileData.value.password,
            "profilePhoto" to (_selectedImageUri.value ?: "")
        )

        viewModelScope.launch {
            // Update Firestore
            FirebaseFirestore.getInstance()
                .collection("Users")
                .document(userEmail)
                .update(userUpdates)
                .await()

            // Update password in FirebaseAuth
            val newPassword = _profileData.value.password
            if (newPassword.isNotEmpty()) {
                val user = FirebaseAuth.getInstance().currentUser
                user?.let {
                    try {
                        it.updatePassword(newPassword).await()
                        // Handle password update success
                    } catch (e: Exception) {
                        // Handle password update error
                    }
                }
            }
        }
    }

    fun discardChanges(){
        //Lógica para deshacer cambios
    }

    fun togglePasswordVisibility() {
        isPasswordVisible.value = !isPasswordVisible.value
    }

}