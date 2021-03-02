package edu.neu.madcourse.numad21f_danpeluso.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MainRepository {

    // calling with Dispatchers.IO removes this from the main thread
    suspend fun getRandomCatFacts(amount: Int) = withContext(Dispatchers.IO) {
        WebServiceClient.webService.getRandomFacts(amount)
    }
}