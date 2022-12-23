package com.upax.androidproject.databaseroom.data.datasourceimplementation.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.upax.androidproject.databaseroom.domain.entity.model.PokemonEntity

@Dao
internal interface PokemonDao : BasicDao<PokemonEntity> {

    @Query("DELETE FROM pokemon")
    suspend fun deleteAll()

    @Query("SELECT * FROM POKEMON")
    suspend fun findAllPokemon() :  List<PokemonEntity>

}