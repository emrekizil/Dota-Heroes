package com.example.home

import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.HeroEntity
import com.example.ui.HomeUiData
import javax.inject.Inject

class HeroHomeUiMapperImpl @Inject constructor() : HeroListMapper<HeroEntity,HomeUiData> {
    override fun map(input: List<HeroEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(
                id = it.id,
                localizedName = it.localizedName,
                img = it.img,
                proWinRate = it.proWinRate,
                primaryAttr = it.primaryAttr
            )
        } ?: emptyList()
    }
}