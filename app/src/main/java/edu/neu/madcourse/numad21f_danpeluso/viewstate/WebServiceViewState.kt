package edu.neu.madcourse.numad21f_danpeluso.viewstate

import edu.neu.madcourse.numad21f_danpeluso.model.CatFact

data class WebServiceViewState(
        val isLoading: Boolean = false,
        val catFacts: List<CatFact> = listOf(),
        val errorMessage: String? = null
) {
}
