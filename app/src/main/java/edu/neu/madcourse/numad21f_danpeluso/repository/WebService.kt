package edu.neu.madcourse.numad21f_danpeluso.repository

import edu.neu.madcourse.numad21f_danpeluso.model.CatFact
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("/facts/random")
    suspend fun getRandomFacts(@Query("amount") amount: Int): List<CatFact>
}