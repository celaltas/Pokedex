package com.bahoz.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.bahoz.pokedex.data.remote.responses.Pokemon
import com.bahoz.pokedex.repository.PokemonRepository
import com.bahoz.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
):ViewModel() {



    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }
}