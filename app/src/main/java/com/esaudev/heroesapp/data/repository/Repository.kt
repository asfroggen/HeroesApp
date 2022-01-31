package com.esaudev.heroesapp.data.repository

import com.esaudev.heroesapp.domain.model.Hero
import com.esaudev.heroesapp.domain.repository.DataStoreOperations
import com.esaudev.heroesapp.domain.repository.LocalDataSource
import com.esaudev.heroesapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes() = remoteDataSource.getAllHeroes()

    fun searchHeroes(query: String) = remoteDataSource.searchHeroes(query = query)

    suspend fun getSelectedHero(heroID: Int): Hero = localDataSource.getSelectedHero(heroID = heroID)

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}