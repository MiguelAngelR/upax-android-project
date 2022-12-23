package com.upax.androidproject.databaseroom.domain.datasourceabstraction

import com.upax.androidproject.databaseroom.data.datasourceimplementation.database.dao.PokemonDao

internal interface AppRoomDatabase {

    fun pokemonDao(): PokemonDao

}