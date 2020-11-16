package com.example.mounikadhanraj.hcatest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuestionListItem
(
    val title : String?,
    val score : Int
):Parcelable

