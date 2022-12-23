package com.upax.androidproject.core.domain.datasourceabstraction.remote

import com.upax.androidproject.common.network.RemoteDataSource
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.core.domain.entity.model.PokemonDetail

interface RemotePokemonDatasource : RemoteDataSource {

    suspend fun fetchPokemon(
        limit:String,
        offset:String
    ): com.upax.androidproject.common.network.Result<List<Pokemon>>

    suspend fun fetchPokemonDetail(
        idPokemon:String
    ): com.upax.androidproject.common.network.Result<PokemonDetail>

}