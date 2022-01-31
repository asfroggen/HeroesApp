package com.esaudev.heroesapp.domain.model

import androidx.annotation.DrawableRes
import com.esaudev.heroesapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Are you a anime fan? Because if you are then we have a great news for you!"
    )
    object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favorite characters and learn some of the things that you didn't know about."
    )
    object Third: OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your character's power and see how much are they strong comparing to others."
    )
}
