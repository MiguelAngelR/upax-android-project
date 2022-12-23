package com.upax.androidproject.network.dto.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal data class PokemonDetailNetwork(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("types") val types: List<Type>,
)

@Keep
internal data class Sprites(
    @SerializedName("back_default") val backDefault: String,
    @SerializedName("back_female") val backFemale: String,
    @SerializedName("back_shiny") val backShiny: String,
    @SerializedName("back_shiny_female") val backShinyFemale: String,
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("front_female") val frontFemale: String,
    @SerializedName("front_shiny") val frontShiny: String,
    @SerializedName("front_shiny_female") val frontShinyFemale: String,
    @SerializedName("other") val other: Others,
)

@Keep
internal data class Type(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: TypeDetail
)

@Keep
internal data class TypeDetail(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

@Keep
internal data class Others(
    @SerializedName("dream_world") val dreamWorld: DreamWorld,
    @SerializedName("home") val home: Home,
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

@Keep
internal data class DreamWorld(
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("front_female") val frontFemale: String,
)

@Keep
internal data class OfficialArtwork(
    @SerializedName("front_default") val frontDefault: String,
)

@Keep
internal data class Home(
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("front_female") val frontFemale: String,
    @SerializedName("front_shiny") val frontShiny: String,
    @SerializedName("front_shiny_female") val frontShinyFemale: String,
)