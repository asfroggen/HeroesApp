package com.esaudev.heroesapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.esaudev.heroesapp.data.local.HeroesDatabase
import com.esaudev.heroesapp.data.paging_source.HeroRemoteMediator
import com.esaudev.heroesapp.data.paging_source.SearchHeroesSource
import com.esaudev.heroesapp.data.remote.HeroesApi
import com.esaudev.heroesapp.domain.model.Hero
import com.esaudev.heroesapp.domain.repository.RemoteDataSource
import com.esaudev.heroesapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val heroesApi: HeroesApi,
    private val heroesDatabase: HeroesDatabase
): RemoteDataSource {

    private val heroDao = heroesDatabase.heroDao()

    @ExperimentalPagingApi
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = {
            heroDao.getAllHeroes()
        }

        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                heroesApi,
                heroesDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(
                    heroesApi = heroesApi,
                    query = query
                )
            }
        ).flow
    }

}