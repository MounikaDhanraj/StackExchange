package com.example.mounikadhanraj.hcatest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mounikadhanraj.hcatest.repository.QuestionRepository

class QuestionViewModelFactory (private val questionRepository: QuestionRepository
):ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(QuestionsViewModel::class.java))
        {
            return QuestionsViewModel(questionRepository) as T
        }

        throw IllegalArgumentException("Unable to construct viewModel")
    }

}