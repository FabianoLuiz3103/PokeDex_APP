package br.com.fabianoluiz.listapokemon.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import br.com.fabianoluiz.listapokemon.data.api.PokeApiService
import br.com.fabianoluiz.listapokemon.domain.model.PokemonDetail

class PokemonRepository(private val apiService: PokeApiService) {
    fun getPokemonList() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { PokemonPagingSource(apiService) }
    ).liveData

    suspend fun getPokemonData(id: Int): PokemonDetail {
        val response = apiService.getPokemon(id)

        val sprites = listOfNotNull(
            response.sprites.front_default,
            response.sprites.back_default,
            response.sprites.front_shiny,
            response.sprites.back_shiny
        )
        return PokemonDetail(
            response.id,
            response.name,
            response.sprites.other.officialArtwork.frontDefault,
            sprites,
            response.stats.find { it.stat.name == "hp" }?.baseStat ?: 0,
            response.stats.find { it.stat.name == "attack" }?.baseStat ?: 0,
            response.stats.find { it.stat.name == "defense" }?.baseStat ?: 0,
            response.stats.find { it.stat.name == "speed" }?.baseStat ?: 0,
        )
    }
}