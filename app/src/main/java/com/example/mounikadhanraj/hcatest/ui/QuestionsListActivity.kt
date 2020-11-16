package com.example.mounikadhanraj.hcatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mounikadhanraj.hcatest.R
import com.example.mounikadhanraj.hcatest.model.QuestionListItem
import com.example.mounikadhanraj.hcatest.repository.QuestionsRepositoryImpl
import com.example.mounikadhanraj.hcatest.ui.viewmodel.QuestionViewModelFactory
import com.example.mounikadhanraj.hcatest.ui.viewmodel.QuestionsViewModel
import com.example.mounikadhanraj.hcatest.util.Status
import kotlinx.android.synthetic.main.activity_questions_list.*

class QuestionsListActivity : AppCompatActivity() {

    private lateinit var viewModel: QuestionsViewModel
    private lateinit var questionsAdapter: QuestionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_list)

        setupViewModel()
        observeViewModel()
    }

    private fun setupViewModel() {

        showProgress()
        viewModel = ViewModelProvider(
            this,
            QuestionViewModelFactory(
                QuestionsRepositoryImpl()
            )
        ).get(QuestionsViewModel::class.java)
    }

    private fun observeViewModel() {
        viewModel.getQuestionsList().observe(this, Observer

        {

            Log.d("status", it.status.toString())

            when (it.status){

                Status.SUCCESS -> {
                    hideProgress()
                    it.data?.let  { questions->(showQuestionsList(questions))}
                }
                Status.ERROR->{
                    hideProgress()
                    (it.message?.let {errorMessage-> showErrorMessage(errorMessage) })
                    questionsListRecyclerView.visibility = View.GONE
                }
                Status.LOADING->{
                    showProgress()
                    questionsListRecyclerView.visibility = View.GONE
                }
            }
        })
    }

    private fun showQuestionsList(questions:List<QuestionListItem>)
    {
        questionsListRecyclerView.layoutManager = LinearLayoutManager(this)

        questionsListRecyclerView.addItemDecoration(
            DividerItemDecoration(
                questionsListRecyclerView.context,
                (questionsListRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )

        questionsListRecyclerView.visibility = View.VISIBLE

        questionsListRecyclerView.setHasFixedSize(true)

        questionsAdapter = QuestionsAdapter()

        questionsAdapter.loadQuestionList(questions)

        questionsListRecyclerView.adapter = questionsAdapter

    }

    private fun showErrorMessage(errorMessage: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(R.string.dialog_title)
            .setMessage(errorMessage)
            .setPositiveButton(R.string.dialog_button) { dialog, which -> dialog.dismiss() }
        builder.show()
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
    }
}