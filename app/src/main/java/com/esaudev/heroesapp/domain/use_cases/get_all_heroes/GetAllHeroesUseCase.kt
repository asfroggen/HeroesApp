package com.esaudev.heroesapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.esaudev.heroesapp.data.repository.Repository
import com.esaudev.heroesapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }

}