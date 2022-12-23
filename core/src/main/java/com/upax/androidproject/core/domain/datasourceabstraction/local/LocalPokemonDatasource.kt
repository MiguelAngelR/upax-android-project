package com.upax.androidproject.core.domain.datasourceabstraction.local

import com.upax.androidproject.core.domain.entity.model.Pokemon

interface LocalPokemonDatasource {

    suspend fun insert(model: Pokemon): Long

    suspend fun insert(models: List<Pokemon>)

    suspend fun update(model: Pokemon)

    suspend fun update(models: List<Pokemon>)

    suspend fun delete(model: Pokemon)

    suspend fun deleteAll()

    suspend fun findAllPokemon() : List<Pokemon>

}