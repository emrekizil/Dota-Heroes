package com.example.data.mapper

import com.example.common.mapper.HeroListMapper
import com.example.data.dto.DotaResponseItem
import com.example.domain.entity.HeroEntity
import javax.inject.Inject

class HeroListMapperImpl @Inject constructor() : HeroListMapper<DotaResponseItem, HeroEntity> {
    override fun map(input: List<DotaResponseItem>?): List<HeroEntity> {
        return input?.map {
            HeroEntity(
                icon = it.icon,
                id = it.id,
                img = it.img,
                name = it.name,
                localizedName = it.localizedName,
                moveSpeed = it.moveSpeed,
                roles = it.roles,
                primaryAttr = it.primaryAttr,
                baseArmor = it.baseArmor,
                baseHealth = it.baseHealth,
                baseMana = it.baseMana,
                attackType = it.attackType,
                attackRange = it.attackRange,
                proWinRate = calculatePercentage(it.proWin,it.proPick),
                turboWinRate = calculatePercentage(it.turboWins,it.turboPicks)
            )
        } ?: emptyList()
    }
}

fun calculatePercentage(winNumber:Int,pickNumber:Int) : Int =  (winNumber * 100) / pickNumber