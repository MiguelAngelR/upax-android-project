package com.upax.androidproject.network.service

import androidx.annotation.Keep
import com.upax.androidproject.network.dto.response.PokemonDetailNetwork
import com.upax.androidproject.network.dto.response.PokemonResponseDTO
import com.upax.androidproject.network.utils.API_RELATIVE_URL
import retrofit2.http.*

@Keep
internal interface PokemonService {

    @GET("$API_RELATIVE_URL/pokemon")
    suspend fun fetchPokemons(
        @Query("limit") limit: String,
        @Query("offset") offset: String,
    ): PokemonResponseDTO

    @GET("$API_RELATIVE_URL/pokemon/{idPokemon}/")
    suspend fun fetchDetailPokemon(
        @Path("idPokemon") idPokemon: String,
    ): PokemonDetailNetwork


}