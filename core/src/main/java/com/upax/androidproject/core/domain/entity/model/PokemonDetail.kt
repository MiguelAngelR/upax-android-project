package com.upax.androidproject.core.domain.entity.model

data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val height: Int,
    val weight: Int,
    val types: List<Type>?,
)

data class Sprites(
    val backDefault: String,
    val backFemale: String,
    val backShiny: String,
    val backShinyFemale: String,
    val frontDefault: String,
    val frontFemale: String,
    val frontShiny: String,
    val frontShinyFemale: String,
    val other: Others?,
)

data class Type(
    val slot: Int,
    val type: TypeDetail
)

data class TypeDetail(
    val name: String,
    val url: String
)

data class Others(
    val dreamWorld: DreamWorld,
    val home: Home,
    val officialArtwork: OfficialArtwork
)

data class DreamWorld(
    val frontDefault: String,
    val frontFemale: String,
)

data class OfficialArtwork(
    val frontDefault: String,
)

data class Home(
    val frontDefault: String,
    val frontFemale: String,
    val frontShiny: String,
    val frontShinyFemale: String,
)

