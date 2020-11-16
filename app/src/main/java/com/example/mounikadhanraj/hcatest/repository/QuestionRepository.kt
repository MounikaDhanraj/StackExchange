package com.example.mounikadhanraj.hcatest.repository


import com.example.mounikadhanraj.hcatest.model.QuestionResponse

interface QuestionRepository {

    suspend fun getQuestionsResponse():QuestionResponse
}