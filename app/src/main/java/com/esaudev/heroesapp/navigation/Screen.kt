package com.esaudev.heroesapp.navigation

sealed class Screen(val route: String) {
    object Splash: Screen(route = "splash_screen")
    object Welcome: Screen(route = "welcome_screen")
    object Home: Screen(route = "home_screen")
    object Details: Screen(route = "details_screen/{heroID}") {
        fun passHeroID(heroID: Int): String {
            return "details_screen/$heroID"
        }
    }

    object Search: Screen(route = "search_screen")
}
