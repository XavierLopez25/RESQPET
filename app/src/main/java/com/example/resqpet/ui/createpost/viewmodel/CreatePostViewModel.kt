package com.example.resqpet.ui.createpost.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resqpet.ui.donation.viewmodel.DonationData

class CreatePostViewModel: ViewModel(){

    val postData = MutableLiveData(Post("", "", null, null))

    val postAdoption = MutableLiveData(PostAdoption("", "", false, false, "", "", "", "", "", false, false))

    val postEventHC = MutableLiveData(PostEventHC("", "", "", "", "", "", "", "", ""))

    fun submitDonation() {

    }

    fun cancelDonation() {

    }

}