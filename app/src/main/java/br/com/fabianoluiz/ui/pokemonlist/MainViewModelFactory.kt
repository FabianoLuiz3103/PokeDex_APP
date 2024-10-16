package br.com.fabianoluiz.ui.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fabianoluiz.listapokemon.data.PokemonRepository
import br.com.fabianoluiz.ui.main.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: PokemonRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}