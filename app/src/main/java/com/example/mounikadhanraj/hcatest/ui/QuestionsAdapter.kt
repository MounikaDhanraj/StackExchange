package com.example.mounikadhanraj.hcatest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mounikadhanraj.hcatest.R
import com.example.mounikadhanraj.hcatest.model.QuestionListItem


class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.MyViewHolder>()
{
    private var questionsList : ArrayList<QuestionListItem> = ArrayList()

    fun loadQuestionList(questionList: List<QuestionListItem>)
    {
        questionsList.clear()
        questionsList.addAll(questionList)
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsAdapter.MyViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val questionTitle = questionsList[position].title
        holder.questiontitle.text=questionTitle
    }

    class MyViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView)
    {
        val questiontitle = itemView.findViewById<TextView>(R.id.question_title)
    }

}