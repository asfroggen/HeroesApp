package com.esaudev.heroesapp.di

import com.esaudev.heroesapp.data.repository.DataStoreOperationsImpl
import com.esaudev.heroesapp.data.repository.LocalDataSourceImpl
import com.esaudev.heroesapp.data.repository.RemoteDataSourceImpl
import com.esaudev.heroesapp.domain.repository.DataStoreOperations
import com.esaudev.heroesapp.domain.repository.LocalDataSource
import com.esaudev.heroesapp.domain.repository.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
abstract class RepositoryModule {

    @Binds
    abstract fun bindDataStoreOperations(
        dataStoreOperations: DataStoreOperationsImpl
    ): DataStoreOperations

    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSource: RemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(
        localDataSource: LocalDataSourceImpl
    ): LocalDataSource

}