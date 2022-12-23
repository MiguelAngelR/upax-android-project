package com.upax.androidproject.domain.usecaseaimplementation

import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.core.domain.repositoryabstraction.PokemonRepository
import com.upax.androidproject.domain.usecaseabstraction.PokemonUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow

internal class PokemonUseCaseImpl(
    coroutineScope: CoroutineScope,
    private val pokemonRepository: PokemonRepository
) : PokemonUseCase {


    override val pokemonList: Flow<List<Pokemon>?> = pokemonRepository.findAllPokemons()

    override suspend fun fetchPokemons(limit: String, offset: String) {
        coroutineScope {
            pokemonRepository.fetchPokemon(limit = limit, offset = offset)
        }
    }

}