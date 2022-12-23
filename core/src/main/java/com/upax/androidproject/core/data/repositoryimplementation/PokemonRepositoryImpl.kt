package com.upax.androidproject.core.data.repositoryimplementation

import com.upax.androidproject.core.domain.datasourceabstraction.local.LocalPokemonDatasource
import com.upax.androidproject.core.domain.datasourceabstraction.remote.RemotePokemonDatasource
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.core.domain.entity.model.PokemonDetail
import com.upax.androidproject.core.domain.repositoryabstraction.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

internal class PokemonRepositoryImpl(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val localPokemonDataSource: LocalPokemonDatasource,
    private val remotePokemonDataSource: RemotePokemonDatasource,
) : PokemonRepository {

    ///////////////////////// Database methods /////////////////////////
    override fun findAllPokemons(): Flow<List<Pokemon>?> =
        TODO("Not yet implemented")


    override suspend fun insert(model: Pokemon): Long =
        localPokemonDataSource.insert(model)


    override suspend fun insert(models: List<Pokemon>) =
        localPokemonDataSource.insert(models)


    override suspend fun update(model: Pokemon) =
        localPokemonDataSource.update(model)


    override suspend fun update(models: List<Pokemon>) =
        localPokemonDataSource.update(models)


    override suspend fun delete(model: Pokemon) =
        localPokemonDataSource.delete(model)


    override suspend fun deleteAll() =
        localPokemonDataSource.deleteAll()


    /////////////////////////// Remote methods ////////////////////////

    override suspend fun fetchPokemon(
        limit: String,
        offset: String)
    : com.upax.androidproject.common.network.Result<List<Pokemon>> = withContext(coroutineDispatcher){
        remotePokemonDataSource.fetchPokemon(
            limit = limit,
            offset = offset
        )
    }

    override suspend fun fetchDetailPokemon(
        idPokemon: String
    ): com.upax.androidproject.common.network.Result<PokemonDetail?> = withContext(coroutineDispatcher){
        remotePokemonDataSource.fetchPokemonDetail(
            idPokemon = idPokemon
        )
    }


}