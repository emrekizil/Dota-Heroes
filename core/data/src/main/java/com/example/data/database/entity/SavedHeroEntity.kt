package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_heroes")
data class SavedHeroEntity(
    @PrimaryKey
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
)
