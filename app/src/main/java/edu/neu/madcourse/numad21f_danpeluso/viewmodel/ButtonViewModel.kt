package edu.neu.madcourse.numad21f_danpeluso.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ButtonViewModel : ViewModel() {

    private var buttonLastPressed: MutableLiveData<String?> = MutableLiveData()

    init {
        buttonLastPressed.value = ""
    }

    fun setButtonLastPressed(newVal: String) {
        buttonLastPressed.value = newVal
    }

    fun getButtonLastPressed() = buttonLastPressed
}