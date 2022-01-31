package com.esaudev.heroesapp.domain.use_cases.get_selected_hero

import com.esaudev.heroesapp.data.repository.Repository
import com.esaudev.heroesapp.domain.model.Hero

class GetSelectedHeroUseCase (
    private val repository: Repository
) {

    suspend operator fun invoke(heroID: Int) : Hero {
        return repository.getSelectedHero(heroID = heroID)
    }
}