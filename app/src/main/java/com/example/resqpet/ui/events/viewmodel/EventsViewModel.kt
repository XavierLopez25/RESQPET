package com.example.resqpet.ui.events.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainEventViewModel : ViewModel() {
    private val _eventInfo = MutableStateFlow(EventsInfo("", "", "", "",""))
    val eventsInfo: StateFlow<EventsInfo> = _eventInfo

    init {
        // Simulación de carga de datos desde alguna fuente cuando se inicializa el ViewModel
        loadData()
    }

    private fun loadData() {
        _eventInfo.value =
            EventsInfo("FoundationName", "12:00 PM", "12", "Small", "123 Address")
    }

    fun onAssistClicked() {
        // Lógica para "Assist". Podría ser navegar a otra pantalla, realizar un registro, etc.
    }
}


