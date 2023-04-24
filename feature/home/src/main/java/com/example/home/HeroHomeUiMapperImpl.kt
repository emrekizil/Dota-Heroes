package com.example.home

import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.HeroEntity
import com.example.ui.HomeUiData

class HeroHomeUiMapperImpl : HeroListMapper<HeroEntity,HomeUiData> {
    override fun map(input: List<HeroEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(
                id = it.id,
                localizedName = it.localizedName,
                img = it.img
            )
        } ?: emptyList()
    }
}