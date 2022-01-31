package com.esaudev.heroesapp.data.remote

import com.esaudev.heroesapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroesApi {

    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}