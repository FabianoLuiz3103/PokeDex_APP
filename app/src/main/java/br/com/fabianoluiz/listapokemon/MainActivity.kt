package br.com.fabianoluiz.listapokemon

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import br.com.fabianoluiz.listapokemon.data.PokemonRepository
import br.com.fabianoluiz.listapokemon.data.api.ApiClient
import br.com.fabianoluiz.listapokemon.databinding.ActivityMainBinding
import br.com.fabianoluiz.ui.main.MainListAdapter
import br.com.fabianoluiz.ui.main.MainViewModel
import br.com.fabianoluiz.ui.pokemonlist.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(PokemonRepository(ApiClient.createPokeApiService()))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = MainListAdapter { view, pokemon ->
            // Configurar a troca de tela
            Toast.makeText(this, pokemon.name, Toast.LENGTH_LONG).show()
        }
        //binding.pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pokemonRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.pokemonRecyclerView.adapter = adapter
        viewModel.pokemonList.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}