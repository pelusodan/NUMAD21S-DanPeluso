package edu.neu.madcourse.numad21f_danpeluso.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.neu.madcourse.numad21f_danpeluso.model.Link

class LinkCollectorViewModel : ViewModel() {
    val linksLiveData: MutableLiveData<List<Link>> = MutableLiveData(listOf())

    fun addLinkToList(name: String, url: String) {
        linksLiveData.postValue(linksLiveData.value?.plus((Link(name, url))))
    }
}