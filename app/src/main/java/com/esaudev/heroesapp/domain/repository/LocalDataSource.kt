package com.esaudev.heroesapp.domain.repository

import com.esaudev.heroesapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroID: Int): Hero
}