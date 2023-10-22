package com.example.resqpet.ui.register.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// RegisterViewModel.kt
class RegisterViewModel(): ViewModel() {

    // MutableStateFlow privados
    private val _username = MutableStateFlow("")
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _passwordVisible = MutableStateFlow(false)

    // Exponer como StateFlow
    val username: StateFlow<String> = _username
    val email: StateFlow<String> = _email
    val password: StateFlow<String> = _password
    val passwordVisible: StateFlow<Boolean> = _passwordVisible

    // Métodos para cambiar los valores
    fun setUsername(username: String) {
        _username.value = username
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun togglePasswordVisibility() {
        _passwordVisible.value = !_passwordVisible.value // Esto cambia el valor actual a su opuesto
    }

    fun onRegisterClicked(username: String, email: String, password: String) {
        viewModelScope.launch {
            registerUser(User(username, email, password))
            // Handle any post-registration logic here (e.g., updating the UI)
        }
    }

    fun registerUser(user: User) {
        // Lógica para enviar datos del usuario a la API
    }

}