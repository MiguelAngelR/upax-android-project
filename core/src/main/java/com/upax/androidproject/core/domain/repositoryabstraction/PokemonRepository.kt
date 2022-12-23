package com.upax.androidproject.core.domain.repositoryabstraction

import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.core.domain.entity.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonRepository : BasicLocalRepository<Pokemon> {

    ///////////////////////// Database methods /////////////////////////

    fun findAllPokemons(): Flow<List<Pokemon>?>

    /////////////////////////// Remote methods ////////////////////////

    suspend fun fetchPokemon(
        limit: String,
        offset: String,
    ): com.upax.androidproject.common.network.Result<List<Pokemon>>

    suspend fun fetchDetailPokemon(idPokemon: String): com.upax.androidproject.common.network.Result<PokemonDetail?>

}