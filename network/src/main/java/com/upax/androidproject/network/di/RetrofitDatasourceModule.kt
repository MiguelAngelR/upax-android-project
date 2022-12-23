package com.upax.androidproject.network.di

import com.upax.androidproject.core.domain.datasourceabstraction.remote.RemotePokemonDatasource
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.network.datasourceimplementation.RemotePokemonDatasourceImpl
import com.upax.androidproject.network.service.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitDatasourceModule {

    @Singleton
    @Provides
    fun provideRemoteClientDatasource(pokemonService: PokemonService ):RemotePokemonDatasource =
        RemotePokemonDatasourceImpl(pokemonService = pokemonService)

}