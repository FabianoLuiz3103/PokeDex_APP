package br.com.fabianoluiz.listapokemon.data.api.model.detail

import br.com.fabianoluiz.listapokemon.data.api.model.Sprites
import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(

    val id: Int,
    val name: String,
    val imageUrl: String,
    val sprites: Sprites,
    val stats: List<Stats>
)

data class Stats(
    @SerializedName("base_stat") val baseStat: Int,
    val stat: Stat
)

data class Stat(
    @SerializedName("name") val name: String?
)