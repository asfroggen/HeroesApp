package com.esaudev.heroesapp.domain.use_cases.save_onboarding

import com.esaudev.heroesapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}