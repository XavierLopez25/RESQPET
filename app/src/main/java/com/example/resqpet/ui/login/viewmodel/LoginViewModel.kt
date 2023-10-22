package com.example.resqpet.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val isPasswordVisible = MutableStateFlow(false)


    // Métodos para actualizar esos estados
    fun setEmail(newEmail: String) {
        email.value = newEmail
    }

    fun setPassword(newPassword: String) {
        password.value = newPassword
    }

    // Método para cambiar el estado de visibilidad de la contraseña
    fun togglePasswordVisibility() {
        isPasswordVisible.value = !isPasswordVisible.value
    }


    // Método para manejar la lógica de inicio de sesión
    fun onLoginClicked() {

    }
}
