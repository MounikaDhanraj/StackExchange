package com.example.mounikadhanraj.hcatest.repository

import com.example.mounikadhanraj.hcatest.api.APIClient

class QuestionsRepositoryImpl : QuestionRepository{

    private val apiService = APIClient.apiService

    override suspend fun getQuestionsResponse() = apiService.getQuestionsResponse()
}