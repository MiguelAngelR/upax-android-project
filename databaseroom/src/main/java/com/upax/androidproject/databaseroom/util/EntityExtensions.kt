package com.upax.androidproject.databaseroom.util

import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.databaseroom.domain.entity.model.PokemonEntity


internal fun Pokemon.asPokemonEntity() =
    PokemonEntity(
        name = name,
        url = url
    )

internal fun List<Pokemon>.asPokemonEntityList() =
    map{
        PokemonEntity(
            name = it.name,
            url = it.url
        )
    }

internal fun List<PokemonEntity>.asPokemonModelList() =
    map {
        Pokemon(
            name = it.name,
            url = it.url
        )
    }