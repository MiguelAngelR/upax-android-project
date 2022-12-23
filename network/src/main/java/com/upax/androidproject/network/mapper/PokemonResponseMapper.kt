package com.upax.androidproject.network.mapper

import com.upax.androidproject.core.domain.entity.model.*
import com.upax.androidproject.network.dto.response.PokemonDetailNetwork
import com.upax.androidproject.network.dto.response.PokemonNetwork
import com.upax.androidproject.network.dto.response.PokemonResponseDTO
import com.upax.androidproject.network.dto.response.Sprites

internal fun List<PokemonNetwork>.asPokemonModelList(): List<Pokemon> =
     map{
        Pokemon(
            name = it.name,
            url = it.url
        )
    }


internal fun PokemonDetailNetwork.asPokemonModelDetail(): PokemonDetail =
    PokemonDetail(
        id =  id,
        name = name,
        sprites = sprites.asSpriteModel(),
        height = height,
        weight = weight,
        types = null,
)

internal fun Sprites.asSpriteModel(): com.upax.androidproject.core.domain.entity.model.Sprites =
    Sprites(
        backDefault = backDefault,
        backFemale = backFemale,
        backShiny = backShiny,
        backShinyFemale = backShinyFemale,
        frontDefault = frontDefault,
        frontFemale = frontFemale,
        frontShiny = frontShiny,
        frontShinyFemale = frontShinyFemale,
        other = null,
    )