package com.example.data.api

import com.example.data.dto.DotaResponse
import retrofit2.http.GET


interface DotaApi {
    @GET("api/heroStats")
    suspend fun getAllHeroes() : DotaResponse
}