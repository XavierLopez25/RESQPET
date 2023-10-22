package com.example.resqpet.ui.donation.viewmodel

data class DonationData(
    var contributorName: String,
    var phoneNumber: String,
    var address: String,
    var donateMonetary: Boolean,
    var donateMedicalResources: Boolean,
    var donateFood: Boolean,
    var belongsToFoundation: Boolean
)
