package com.example.data.di

import com.example.data.source.local.LocalDataSource
import com.example.data.source.local.LocalDataSourceImpl
import com.example.data.source.local.datastore.FilterPreferenceSource
import com.example.data.source.local.datastore.FilterPreferenceSourceImpl
import com.example.data.source.remote.RemoteDataSource
import com.example.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindLocalDataStoreSource(filterPreferenceSourceImpl: FilterPreferenceSourceImpl):FilterPreferenceSource

    @Binds
    @ViewModelScoped
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}