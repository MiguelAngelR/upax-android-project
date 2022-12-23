package com.upax.androidproject.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.domain.usecaseabstraction.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {

    val pokemonList: Flow<List<Pokemon>?> = pokemonUseCase.pokemonList

    init {
        viewModelScope.launch {
            pokemonUseCase.fetchPokemons("20", "1")
        }
    }

}
