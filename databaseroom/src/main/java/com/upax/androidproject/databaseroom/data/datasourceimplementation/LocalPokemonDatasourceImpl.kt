package com.upax.androidproject.databaseroom.data.datasourceimplementation

import com.upax.androidproject.core.domain.datasourceabstraction.local.LocalPokemonDatasource
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.databaseroom.data.datasourceimplementation.database.dao.PokemonDao
import com.upax.androidproject.databaseroom.util.asPokemonEntity
import com.upax.androidproject.databaseroom.util.asPokemonEntityList
import com.upax.androidproject.databaseroom.util.asPokemonModelList

internal class LocalPokemonDatasourceImpl(private val pokemonDao: PokemonDao) :
    LocalPokemonDatasource {

    override suspend fun insert(model: Pokemon): Long =
        pokemonDao.insert(model.asPokemonEntity())

    override suspend fun insert(models: List<Pokemon>) =
        pokemonDao.insert(models.asPokemonEntityList())

    override suspend fun update(model: Pokemon) =
        pokemonDao.update(model.asPokemonEntity())

    override suspend fun update(models: List<Pokemon>) =
        pokemonDao.update(models.asPokemonEntityList())

    override suspend fun delete(model: Pokemon) =
        pokemonDao.delete(model.asPokemonEntity())

    override suspend fun deleteAll() =
        pokemonDao.deleteAll()

    override suspend fun findAllPokemon(): List<Pokemon> =
        pokemonDao.findAllPokemon().asPokemonModelList()

}