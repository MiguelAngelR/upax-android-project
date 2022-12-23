package com.upax.androidproject.network.dto.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal data class PokemonResponseDTO(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<PokemonNetwork>
)

@Keep
internal data class PokemonNetwork(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)