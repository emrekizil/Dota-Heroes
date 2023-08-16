package com.example.domain.entity

data class HeroEntity(
    val icon: String,
    val id: Int,
    val img: String,
    val name: String,
    val localizedName: String,
    val moveSpeed: Int,
    val roles: List<String>,
    val primaryAttr: String,
    val baseMana: Int,
    val baseHealth: Int,
    val baseArmor: Double,
    val attackType: String,
    val attackRange: Int,
    val proWinRate:Int,
    val turboWinRate:Int,
    val projectileSpeed:Int,
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
