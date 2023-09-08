package com.example.home.saved

import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.SavedHeroDomainEntity
import com.example.ui.HeroUiData
import javax.inject.Inject


class HeroUiToDomainMapperImpl @Inject constructor() : HeroListMapper<SavedHeroDomainEntity,HeroUiData>{
    override fun map(input: List<SavedHeroDomainEntity>?): List<HeroUiData> {

        return input?.map {
               HeroUiData(
                   id = it.id,
                   localizedName = it.localizedName,
                   img = it.img,
                   proWinRate = it.proWinRate,
                   primaryAttr = it.primaryAttr,
                   attackType = it.attackType,
                   attackRange = it.attackRange,
                   baseStr = it.baseStr,
                   baseInt = it.baseInt,
                   baseAgi = it.baseAgi,
                   strGain = it.strGain,
                   intGain = it.intGain,
                   agiGain = it.agiGain,
                   baseAttackMax = it.baseAttackMax,
                   baseAttackMin = it.baseAttackMin,
                   health = it.health,
                   turboWinRate = it.turboWinRate,
                   projectileSpeed = it.projectileSpeed,
                   moveSpeed = it.moveSpeed,
                   icon = it.icon
               )
        } ?: emptyList()
    }

}

fun HeroUiData.toDomainEntity():SavedHeroDomainEntity{
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