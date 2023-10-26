package com.example.resqpet.ui.health.viewmodel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ServiceRQPViewModel : ViewModel() {
    private val _foundationInfo = MutableStateFlow(FoundationInfo("", "", "", false, false, false))
    val foundationInfo: StateFlow<FoundationInfo> = _foundationInfo

    init {
        // Simulación de carga de datos desde alguna fuente cuando se inicializa el ViewModel
        loadData()
    }

    private fun loadData() {
        _foundationInfo.value =
            FoundationInfo("FoundationName", "12:00 PM", "123 Address", true, false, true)
    }

    fun onCancelClicked() {

    }

    fun onRegisterOrDonateClicked() {

    }
}


