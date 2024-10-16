package br.com.fabianoluiz.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.fabianoluiz.listapokemon.data.PokemonRepository

class MainViewModel(repository: PokemonRepository) : ViewModel() {
    val pokemonList = repository.getPokemonList().cachedIn(viewModelScope)
}