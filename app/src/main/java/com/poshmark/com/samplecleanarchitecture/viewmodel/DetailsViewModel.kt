package com.poshmark.com.samplecleanarchitecture.viewmodel

import android.arch.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {

    var name: String? = null
    var address: String? = null
    var phone: String? = null

    fun clearState() {
        name = null
        address = null
        phone = null
    }

    override fun onCleared() {
        clearState()
    }
}