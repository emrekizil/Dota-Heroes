package com.example.data.source.local

import com.example.data.database.HeroDao
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val heroDao: HeroDao
) : LocalDataSource {

}