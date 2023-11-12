package com.example.resqpet.ui.register.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// RegisterViewModel.kt
class RegisterViewModel(): ViewModel() {

    // MutableStateFlow privados
    private val _username = MutableStateFlow("")
    private val _cname = MutableStateFlow("")
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _passwordC = MutableStateFlow("")
    private val _passwordVisible = MutableStateFlow(false)
    private val _isEmailValid = MutableStateFlow(true)
    private val _passwordsMatch = MutableStateFlow(true)


    // Exponer como StateFlow
    val username: StateFlow<String> = _username
    val Cname: StateFlow<String> = _cname
    val email: StateFlow<String> = _email
    val password: StateFlow<String> = _password
    val passwordC: StateFlow<String> = _passwordC
    val passwordVisible: StateFlow<Boolean> = _passwordVisible
    val isEmailValid: StateFlow<Boolean> = _isEmailValid.asStateFlow()
    val passwordsMatch: StateFlow<Boolean> = _passwordsMatch.asStateFlow()



    // Métodos para cambiar los valores
    fun setUsername(username: String) {
        _username.value = username
    }

    fun setCompleteName(Cname: String) {
        _cname.value = Cname
    }

    fun setEmail(email: String) {
        _email.value = email
        _isEmailValid.value = isEmailValid(email)
    }

    fun setPassword(password: String) {
        _password.value = password
        validatePasswords()
    }

    fun setPasswordC(passwordC: String) {
        _passwordC.value = passwordC
        validatePasswords()
    }

    private fun validatePasswords() {
        _passwordsMatch.value = password.value == passwordC.value
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.isEmpty()
    }

    fun togglePasswordVisibility() {
        _passwordVisible.value = !_passwordVisible.value // Esto cambia el valor actual a su opuesto
    }

    fun onRegisterClicked(username: String, cname: String, email: String, password: String) {
        viewModelScope.launch {
            registerUser(User(username, cname, email, password))
            // Handle any post-registration logic here (e.g., updating the UI)
        }
    }

    fun registerUser(user: User) {
        // Lógica para enviar datos del usuario a la API
    }

}