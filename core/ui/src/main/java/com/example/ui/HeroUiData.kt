package com.example.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroUiData(
    val id: Int,
    val img: String,
    val localizedName: String,
    val proWinRate:Int,
    val primaryAttr:String
) : Parcelable