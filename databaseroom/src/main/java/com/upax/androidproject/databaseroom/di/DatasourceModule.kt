package com.upax.androidproject.databaseroom.di

import com.upax.androidproject.core.domain.datasourceabstraction.local.LocalPokemonDatasource
import com.upax.androidproject.databaseroom.data.datasourceimplementation.LocalPokemonDatasourceImpl
import com.upax.androidproject.databaseroom.data.datasourceimplementation.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DatasourceModule {

    @Singleton
    @Provides
    fun provideLocalPokemonDatasource(pokemonDao: PokemonDao): LocalPokemonDatasource =
        LocalPokemonDatasourceImpl(pokemonDao = pokemonDao)

}