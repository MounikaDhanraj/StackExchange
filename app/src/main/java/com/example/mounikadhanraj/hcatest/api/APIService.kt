package com.example.mounikadhanraj.hcatest.api

import com.example.mounikadhanraj.hcatest.model.QuestionResponse
import retrofit2.http.GET

interface APIService {

        @GET("/search/advanced?order=asc&sort=creation&accepted=True" +
                "&answers=2&site=stackoverflow")
        suspend fun  getQuestionsResponse():QuestionResponse
}