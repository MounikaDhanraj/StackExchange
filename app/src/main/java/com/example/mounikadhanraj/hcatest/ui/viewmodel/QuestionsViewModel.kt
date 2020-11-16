package com.example.mounikadhanraj.hcatest.ui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mounikadhanraj.hcatest.model.QuestionListItem
import com.example.mounikadhanraj.hcatest.repository.QuestionRepository
import com.example.mounikadhanraj.hcatest.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionsViewModel(private val questionRepository: QuestionRepository)
    :ViewModel(){

    val questionResponse = MutableLiveData<Resource<List<QuestionListItem>>>()

    init{
        fetchQuestions()
    }

    private fun fetchQuestions(){
        viewModelScope.launch (Dispatchers.IO)
        {
            try{

                val questionsfromApi = questionRepository.getQuestionsResponse()
                questionResponse.postValue(Resource.success(questionsfromApi.items))
            }
            catch (e:Exception)
            {
                questionResponse.postValue(Resource.error(e.toString(),null))
            }
        }
    }

    fun getQuestionsList(): LiveData<Resource<List<QuestionListItem>>> {
        return questionResponse
    }
}