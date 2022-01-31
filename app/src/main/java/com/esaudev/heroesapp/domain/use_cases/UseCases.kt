package com.esaudev.heroesapp.domain.use_cases

import com.esaudev.heroesapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.esaudev.heroesapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.esaudev.heroesapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.esaudev.heroesapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.esaudev.heroesapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase
)
