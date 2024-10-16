package br.com.fabianoluiz.listapokemon.data.api

import br.com.fabianoluiz.listapokemon.data.api.model.PokemonResponse
import br.com.fabianoluiz.listapokemon.data.api.model.detail.PokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonDetailResponse
}