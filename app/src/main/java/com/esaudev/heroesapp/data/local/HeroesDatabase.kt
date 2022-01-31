package com.esaudev.heroesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.esaudev.heroesapp.data.local.converters.DatabaseConverter
import com.esaudev.heroesapp.data.local.dao.HeroDao
import com.esaudev.heroesapp.data.local.dao.HeroRemoteKeysDao
import com.esaudev.heroesapp.domain.model.Hero
import com.esaudev.heroesapp.domain.model.HeroRemoteKeys

@Database(
    entities = [Hero::class, HeroRemoteKeys::class],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class HeroesDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}