package com.example.mounikadhanraj.hcatest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuestionResponse(
    val items : ArrayList<QuestionListItem>?
): Parcelable
