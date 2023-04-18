package com.example.data.di

import com.example.data.api.DotaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Provides
    @ViewModelScoped
    fun provideApi() : DotaApi{
        return Retrofit.Builder()
            .baseUrl("https://api.opendota.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DotaApi::class.java)
    }
}