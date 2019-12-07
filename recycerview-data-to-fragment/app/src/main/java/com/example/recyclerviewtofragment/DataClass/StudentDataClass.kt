package com.example.recyclerviewtofragment.DataClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StudentDataClass(val name: String, val date: String, val subject: String, val grade: Float, val age: Int):Parcelable