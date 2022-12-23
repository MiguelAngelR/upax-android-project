package com.upax.androidproject.core.di


import com.upax.androidproject.common.coroutine.IoDispatcher
import com.upax.androidproject.core.data.repositoryimplementation.PokemonRepositoryImpl
import com.upax.androidproject.core.domain.datasourceabstraction.local.LocalPokemonDatasource
import com.upax.androidproject.core.domain.datasourceabstraction.remote.RemotePokemonDatasource
import com.upax.androidproject.core.domain.repositoryabstraction.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Singleton
    @Provides
    fun provideClientRepository(
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
        localClientDatasource: LocalPokemonDatasource,
        remoteClientDatasource: RemotePokemonDatasource,
    ): PokemonRepository = PokemonRepositoryImpl(
        coroutineDispatcher = coroutineDispatcher,
        localPokemonDataSource = localClientDatasource,
        remotePokemonDataSource = remoteClientDatasource)

}