package com.esaudev.heroesapp.data.repository

import com.esaudev.heroesapp.data.local.HeroesDatabase
import com.esaudev.heroesapp.domain.model.Hero
import com.esaudev.heroesapp.domain.repository.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(heroesDatabase: HeroesDatabase): LocalDataSource {

    private val heroDao = heroesDatabase.heroDao()

    override suspend fun getSelectedHero(heroID: Int): Hero {
        return heroDao.getSelectedHero(heroID = heroID)
    }

}