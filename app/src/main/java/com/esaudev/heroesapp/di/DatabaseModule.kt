package com.esaudev.heroesapp.di

import android.content.Context
import androidx.room.Room
import com.esaudev.heroesapp.data.local.HeroesDatabase
import com.esaudev.heroesapp.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        HeroesDatabase::class.java,
        HERO_DATABASE
    ).build()


}