package com.example.detail

import com.example.domain.entity.SavedHeroDomainEntity
import com.example.ui.HeroUiData

fun HeroUiData.toDomainEntity(): SavedHeroDomainEntity {
    return SavedHeroDomainEntity(
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