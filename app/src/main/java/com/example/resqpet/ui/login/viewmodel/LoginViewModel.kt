package com.example.resqpet.ui.login.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val isPasswordVisible = MutableStateFlow(false)
    private val _areFieldsValid = MutableStateFlow(true)
    val areFieldsValid: StateFlow<Boolean> = _areFieldsValid.asStateFlow()
    private val _isEmailValid = MutableStateFlow(true)
    val isEmailValid: StateFlow<Boolean> = _isEmailValid.asStateFlow()




    // Métodos para actualizar esos estados
    fun setEmail(newEmail: String) {
        email.value = newEmail
        validateFields()
    }

    fun setPassword(newPassword: String) {
        password.value = newPassword
        validateFields()
    }

    private fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Método para cambiar el estado de visibilidad de la contraseña
    fun togglePasswordVisibility() {
        isPasswordVisible.value = !isPasswordVisible.value
    }

    private fun validateFields() {
        _isEmailValid.value = isEmailValid(email.value)
        _areFieldsValid.value = email.value.isNotBlank() && password.value.isNotBlank() && _isEmailValid.value
    }

    // Método para manejar la lógica de inicio de sesión
    fun onLoginClicked() {

        val email = email.value
        val password = password.value

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d("TESTING LOGIN", "LOGIN SUCCESS!")
                Log.d("TESTING FIREBASE", "isSuccesful = ${it.isSuccessful}")
            }
            .addOnFailureListener {
                Log.d("TESTING LOGIN", "LOGIN FAILED :(")
                Log.d("TESTING FIREBASE", "Exception = ${it.message}")
                Log.d("TESTING FIREBASE", "Exception = ${it.localizedMessage}")
            }

        resetFields()

    }

    private fun resetFields() {
        email.value = ""
        password.value = ""
    }



}
