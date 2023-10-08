package com.example.data.mapper

import com.example.common.mapper.HeroListMapper
import com.example.data.database.entity.DotaResponseItemEntity
import com.example.data.dto.DotaResponseItem
import javax.inject.Inject

class CacheToDotaResponseListImpl @Inject constructor() : HeroListMapper<DotaResponseItemEntity, DotaResponseItem> {

    override fun map(input: List<DotaResponseItemEntity>?): List<DotaResponseItem> {

        return input?.map {
            DotaResponseItem(
                agiGain = it.agiGain,
                attackPoint = it.attackPoint,
                attackRange = it.attackRange,
                attackRate = it.attackRate,
                attackType = it.attackType,
                baseAgi = it.baseAgi,
                baseArmor= it.baseArmor,
                baseAttackMax = it.baseAttackMax,
                baseAttackMin = it.baseAttackMin,
                baseAttackTime = it.baseAttackTime,
                baseHealth= it.baseHealth,
                baseHealthRegen = it.baseHealthRegen,
                baseMana= it.baseMana,
                baseManaRegen= it.baseManaRegen,
                baseMr= it.baseMr,
                baseStr= it.baseStr,
                baseInt= it.baseInt,
                cmEnabled= it.cmEnabled,
                dayVision= it.dayVision,
                heroId= it.heroId,
                icon= it.icon,
                id= it.id,
                img= it.img,
                intGain= it.intGain,
                legs= it.legs,
                localizedName= it.localizedName,
                moveSpeed= it.moveSpeed,
                name= it.name,
                nightVision= it.nightVision,
                nullPick= it.nullPick,
                nullWin= it.nullWin,
                pick1= it.pick1,
                pick2= it.pick2,
                pick3= it.pick3,
                pick4= it.pick4,
                pick5= it.pick5,
                pick6= it.pick6,
                pick7= it.pick7,
                pick8= it.pick8,
                primaryAttr= it.primaryAttr,
                proBan= it.proBan,
                proPick= it.proPick,
                proWin= it.proWin,
                projectileSpeed= it.projectileSpeed,
                roles= it.roles,
                strGain= it.strGain,
                turboPicks= it.turboPicks,
                turboWins= it.turboWins,
                turnRate= it.turnRate,
                win1= it.win1,
                win2= it.win2,
                win3= it.win3,
                win4= it.win4,
                win5= it.win5,
                win6= it.win6,
                win7= it.win7,
                win8= it.win8
            )

        } ?: emptyList()

    }

}