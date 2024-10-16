package br.com.fabianoluiz.listapokemon.data.api.model

import com.google.gson.annotations.SerializedName

data class Pokemon(

    val id: Int,
    val name: String,
    val imageUrl: String,
)
