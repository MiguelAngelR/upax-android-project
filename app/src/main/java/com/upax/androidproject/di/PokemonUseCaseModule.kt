package com.upax.androidproject.di

import com.upax.androidproject.common.di.ApplicationScope
import com.upax.androidproject.core.domain.datasourceabstraction.local.LocalPokemonDatasource
import com.upax.androidproject.core.domain.repositoryabstraction.PokemonRepository
import com.upax.androidproject.domain.usecaseabstraction.PokemonUseCase
import com.upax.androidproject.domain.usecaseaimplementation.PokemonUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(SingletonComponent::class)
internal object PokemonUseCaseModule {

    @Provides
    fun providePokemonUseCase(
        @ApplicationScope coroutineScope: CoroutineScope,
        pokemonRepository: PokemonRepository,
    ): PokemonUseCase = PokemonUseCaseImpl(
        coroutineScope = coroutineScope,
        pokemonRepository = pokemonRepository
    )


}