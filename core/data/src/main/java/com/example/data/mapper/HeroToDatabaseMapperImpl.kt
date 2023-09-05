package com.example.data.mapper

import com.example.data.database.entity.SavedHeroEntity
import com.example.domain.entity.SavedHeroDbEntity


fun SavedHeroEntity.toDomain():SavedHeroDbEntity{
    return SavedHeroDbEntity(
        id = this.id,
        localizedName = this.localizedName,
        img = this.img,
        proWinRate = this.proWinRate,
        primaryAttr = this.primaryAttr,
        attackType = this.attackType,
        attackRange = this.attackRange,
        baseStr = this.baseStr,
        baseInt = this.baseInt,
        baseAgi = this.baseAgi,
        strGain = this.strGain,
        intGain = this.intGain,
        agiGain = this.agiGain,
        baseAttackMax = this.baseAttackMax,
        baseAttackMin = this.baseAttackMin,
        health = this.health,
        turboWinRate = this.turboWinRate,
        projectileSpeed = this.projectileSpeed,
        moveSpeed = this.moveSpeed,
        icon = this.icon
    )
}