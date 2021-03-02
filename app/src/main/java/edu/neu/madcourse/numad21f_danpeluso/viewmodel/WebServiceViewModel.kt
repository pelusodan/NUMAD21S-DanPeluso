package edu.neu.madcourse.numad21f_danpeluso.viewmodel

import androidx.lifecycle.*
import edu.neu.madcourse.numad21f_danpeluso.repository.MainRepository
import edu.neu.madcourse.numad21f_danpeluso.viewstate.WebServiceViewState
import kotlinx.coroutines.*
import java.lang.Exception

class WebServiceViewModel : ViewModel() {

    private val viewState: MutableLiveData<WebServiceViewState> = MutableLiveData()
    val viewStateLiveData: LiveData<WebServiceViewState> = viewState

    fun getCatFacts(amount: Int) {
        viewState.value = WebServiceViewState(isLoading = true)
        viewModelScope.launch {
            try {
                val data = MainRepository.getRandomCatFacts(amount)
                viewState.value = WebServiceViewState(isLoading = false, catFacts = data)
            } catch (e: Exception) {
                viewState.value = WebServiceViewState(errorMessage = e.localizedMessage)
            }
        }
        viewModelScope.coroutineContext
    }
}