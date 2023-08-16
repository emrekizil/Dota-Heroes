package com.example.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroUiData(
    val id: Int,
    val img: String,
    val localizedName: String,
    val proWinRate:Int,
    val primaryAttr:String,
    val turboWinRate:Int,
    val icon:String,
    val attackType:String,
    val moveSpeed:Int,
    val projectileSpeed:Int,
    val attackRange:Int,
    val health:Int,
    val baseStr:Int,
    val strGain:Double,
    val baseAgi:Int,
    val agiGain:Double,
    val baseInt:Int,
    val intGain:Double,
    val baseAttackMin:Int,
    val baseAttackMax:Int
) : Parcelable