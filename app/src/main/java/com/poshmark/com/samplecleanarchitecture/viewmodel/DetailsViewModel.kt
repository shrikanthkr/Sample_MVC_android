package com.poshmark.com.samplecleanarchitecture.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

class DetailsViewModel : ViewModel() {

    private val _mutableNameData = MutableLiveData<String>()
    val nameData: LiveData<String> = _mutableNameData

    private val _mutableAddressData = MutableLiveData<String>()
    val addressData: LiveData<String> = _mutableAddressData

    private val _mutablePhoneData = MutableLiveData<String>()
    val phoneData: LiveData<String> = _mutablePhoneData

    fun setName(name: String) {
        _mutableNameData.postValue(name)
    }

    fun setAddress(address: String) {
        _mutableAddressData.postValue(address)
    }

    fun setPhone(phone: String) {
        _mutablePhoneData.postValue(phone)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModel", "OnCleared is called ${hashCode()}")
    }
}