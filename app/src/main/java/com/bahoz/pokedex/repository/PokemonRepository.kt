package com.bahoz.pokedex.repository

import android.util.Log
import com.bahoz.pokedex.data.remote.PokeApi
import com.bahoz.pokedex.data.remote.responses.Pokemon
import com.bahoz.pokedex.data.remote.responses.PokemonList
import com.bahoz.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject


@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)

        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred ${e.message}")

        }
        Log.e("Repository", "in successs")
        Log.e("Repository", response.toString())
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name = pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred ${e.message}")
        }
        return Resource.Success(response)
    }
}