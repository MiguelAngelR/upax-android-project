package com.upax.androidproject.databaseroom.domain.entity.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "pokemon")
internal data class PokemonEntity(
    @PrimaryKey @ColumnInfo(name = "name") val name: String, //ID
    @ColumnInfo(name = "url") val url: String,
)