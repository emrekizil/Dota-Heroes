package com.example.home

import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.HeroEntity
import com.example.ui.HeroUiData
import javax.inject.Inject

class HeroHomeUiMapperImpl @Inject constructor() : HeroListMapper<HeroEntity,HeroUiData> {
    override fun map(input: List<HeroEntity>?): List<HeroUiData> {
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