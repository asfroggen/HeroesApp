package com.esaudev.heroesapp.di

import com.esaudev.heroesapp.data.repository.Repository
import com.esaudev.heroesapp.domain.use_cases.UseCases
import com.esaudev.heroesapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.esaudev.heroesapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.esaudev.heroesapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.esaudev.heroesapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.esaudev.heroesapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository)
        )
    }
}