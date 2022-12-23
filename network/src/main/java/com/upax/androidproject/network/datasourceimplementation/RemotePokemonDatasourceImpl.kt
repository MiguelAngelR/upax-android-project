package com.upax.androidproject.network.datasourceimplementation

import com.upax.androidproject.common.network.Result
import com.upax.androidproject.core.domain.datasourceabstraction.remote.RemotePokemonDatasource
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.core.domain.entity.model.PokemonDetail
import com.upax.androidproject.network.mapper.asPokemonModelDetail
import com.upax.androidproject.network.mapper.asPokemonModelList
import com.upax.androidproject.network.service.PokemonService


internal class RemotePokemonDatasourceImpl(private val pokemonService: PokemonService) : RemotePokemonDatasource {

    override suspend fun fetchPokemon(limit: String,offset: String): Result<List<Pokemon>> =
        safeApiCall { pokemonService.fetchPokemons(limit = limit, offset = offset ).results.asPokemonModelList() }

    override suspend fun fetchPokemonDetail(idPokemon: String): Result<PokemonDetail> =
        safeApiCall { pokemonService.fetchDetailPokemon(idPokemon = idPokemon).asPokemonModelDetail() }
}