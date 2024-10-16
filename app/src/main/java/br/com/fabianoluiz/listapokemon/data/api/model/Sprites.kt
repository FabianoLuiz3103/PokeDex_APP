package br.com.fabianoluiz.listapokemon.data.api.model

import com.google.gson.annotations.SerializedName

data class Sprites(
    val front_default: String?,
    val back_default: String?,
    val front_shiny: String?,
    val back_shiny: String?,
    val other: Other
)

data class Other(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default") val frontDefault: String
)