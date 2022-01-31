package com.esaudev.heroesapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.esaudev.heroesapp.data.remote.HeroesApi
import com.esaudev.heroesapp.domain.model.Hero
import java.lang.Exception
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val heroesApi: HeroesApi,
    private val query: String
): PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = heroesApi.searchHeroes(name = query)
            val heroes = apiResponse.heroes

            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }

}