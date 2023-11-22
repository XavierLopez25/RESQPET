package com.example.resqpet.ui.register.viewmodel

import android.net.Uri
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
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
    private val _isFormValid = MutableStateFlow(false)
    private val _isPasswordLengthValid = MutableStateFlow(true)
    private var _selectedImageUri = MutableLiveData<String>()


    private val storageReference = FirebaseStorage.getInstance().reference.child("ProfilePhotos")


    // Exponer como StateFlow
    val username: StateFlow<String> = _username
    val Cname: StateFlow<String> = _cname
    val email: StateFlow<String> = _email
    val password: StateFlow<String> = _password
    val passwordC: StateFlow<String> = _passwordC
    val passwordVisible: StateFlow<Boolean> = _passwordVisible
    val isEmailValid: StateFlow<Boolean> = _isEmailValid.asStateFlow()
    val passwordsMatch: StateFlow<Boolean> = _passwordsMatch.asStateFlow()
    val isFormValid: StateFlow<Boolean> = _isFormValid.asStateFlow()
    val isPasswordLengthValid: StateFlow<Boolean> = _isPasswordLengthValid.asStateFlow()
    val selectedImageUri: LiveData<String> get() = _selectedImageUri


    private fun validateForm() {
        _isFormValid.value = username.value.isNotBlank() &&
                Cname.value.isNotBlank() &&
                isEmailValid(email.value) &&
                passwordsMatch.value &&
                _isPasswordLengthValid.value
    }

    private var registrationProgress = mutableStateOf(false)

    fun setUsername(username: String) {
        _username.value = username
        validateForm()
    }

    fun setCompleteName(Cname: String) {
        _cname.value = Cname
        validateForm()
    }

    fun setEmail(email: String) {
        _email.value = email
        _isEmailValid.value = isEmailValid(email)
        validateForm()
    }

    fun setPassword(password: String) {
        _password.value = password
        validatePasswords()
        validateForm()
    }

    fun setPasswordC(passwordC: String) {
        _passwordC.value = passwordC
        validatePasswords()
        validateForm()
    }


    private fun validatePasswords() {
        _passwordsMatch.value = password.value == passwordC.value
        _isPasswordLengthValid.value = password.value.length >= 6 && passwordC.value.length >= 6
    }

    private fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun togglePasswordVisibility() {
        _passwordVisible.value = !_passwordVisible.value // Esto cambia el valor actual a su opuesto
    }

    fun onRegisterClicked(username: String, cname: String, email: String, password: String, profilePhoto: String?) {
        viewModelScope.launch {
            createUserInFirebase(User(username, cname, email, password, profilePhoto))
            resetFields()
        }
    }

    fun saveImageUri(uri: Uri?) {
        uri?.let {
            uploadImageToFirebaseStorage(it) { downloadUrl ->
                _selectedImageUri.value = downloadUrl.toString() // Save download URL instead of local URI
            }
        }
    }

    private fun uploadImageToFirebaseStorage(imageUri: Uri, onSuccess: (Uri) -> Unit) {
        val ref = storageReference.child("profilephotos/${System.currentTimeMillis()}.jpg")
        ref.putFile(imageUri)
            .addOnSuccessListener { taskSnapshot ->
                taskSnapshot.metadata?.reference?.downloadUrl?.addOnSuccessListener { downloadUri ->
                    onSuccess(downloadUri)
                }
            }
            .addOnFailureListener {
                // Handle failure...
            }
    }

    private fun resetFields() {
        _username.value = ""
        _cname.value = ""
        _email.value = ""
        _password.value = ""
        _passwordC.value = ""
    }




    private fun createUserInFirebase(user: User) {

        registrationProgress.value = true

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener {
                Log.d("TESTING FIREBASE", "COMPLETED!")
                Log.d("TESTING FIREBASE", "isSuccesful = ${it.isSuccessful}")
                registrationProgress.value = false
            }
            .addOnFailureListener {
                Log.d("TESTING FIREBASE", "FAILURE")
                Log.d("TESTING FIREBASE", "Exception = ${it.message}")
                Log.d("TESTING FIREBASE", "Exception = ${it.localizedMessage}")
            }

        FirebaseFirestore.getInstance().collection("Users").document(user.email).set(user)
            .addOnCompleteListener {
                Log.d("USER COLLECTION", "COMPLETED!")
                Log.d("USER COLLECTION", "isSuccesful = ${it.isSuccessful}")
                registrationProgress.value = false
            }
            .addOnFailureListener {
                Log.d("USER COLLECTION", "FAILURE")
                Log.d("USER COLLECTION", "Exception = ${it.message}")
                Log.d("USER COLLECTION", "Exception = ${it.localizedMessage}")
            }
    }

    fun logOut(){

        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val authStateListener = AuthStateListener{
            if(it.currentUser == null){
                Log.d("TESTING LOGOUT", "LOGOUT SUCCESS!")
            }else{
                Log.d("TESTING LOGOUT", "LOGOUT FAILED :(")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }

}