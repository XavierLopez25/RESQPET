package com.example.resqpet.ui.donation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DonationViewModel: ViewModel(){

    val donationData = MutableLiveData(DonationData("", "", "", false, false, false, false))

    fun submitDonation(contributorName: String, phoneNumber: String, address: String, donateMonetary: Boolean, donateMedicalResources: Boolean, donateFood: Boolean) {
    }

    fun cancelDonation(contributorName: String, phoneNumber: String, address: String, donateMonetary: Boolean, donateMedicalResources: Boolean, donateFood: Boolean) {
    }

}