package com.upax.androidproject.databaseroom.di

import com.upax.androidproject.databaseroom.data.datasourceimplementation.database.dao.PokemonDao
import com.upax.androidproject.databaseroom.domain.datasourceabstraction.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {


    @Provides
    fun provideClientDao(roomDatabase: AppRoomDatabase): PokemonDao =
        roomDatabase.pokemonDao()

}