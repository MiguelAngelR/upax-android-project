package com.upax.androidproject.domain.usecaseabstraction

import com.upax.androidproject.core.domain.entity.model.Pokemon
import kotlinx.coroutines.flow.Flow

internal interface PokemonUseCase {

    /**
     * Pokemon list data as a flow.
     */
    val pokemonList: Flow<List<Pokemon>?>

    suspend fun fetchPokemons(limit: String, offset:String)

}