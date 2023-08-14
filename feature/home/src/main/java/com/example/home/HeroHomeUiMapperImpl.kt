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
                primaryAttr = it.primaryAttr
            )
        } ?: emptyList()
    }
}