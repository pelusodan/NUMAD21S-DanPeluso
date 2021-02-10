package edu.neu.madcourse.numad21f_danpeluso.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.neu.madcourse.numad21f_danpeluso.model.Link

class LinkCollectorViewModel : ViewModel() {
    val linksLiveData: MutableLiveData<List<Link>> = MutableLiveData(listOf())

    fun addLinkToList(name: String, url: String) {
        linksLiveData.postValue(linksLiveData.value?.plus((Link(name, url))))
    }

    fun removeLinkAt(position: Int) {
        // some fancy kotlin to get the position of the element if it is in the list, and remove it
        // after being null checked
        linksLiveData.value?.getOrNull(position)?.let {
            linksLiveData.postValue(linksLiveData.value?.minus(it))
        }
    }

    fun getNameFromPosition(position: Int): String = linksLiveData.value?.get(position)?.name ?: ""

}