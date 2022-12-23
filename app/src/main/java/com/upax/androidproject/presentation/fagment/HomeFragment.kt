package com.upax.androidproject.presentation.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.upax.androidproject.databinding.FragmentHomeBinding
import com.upax.androidproject.presentation.adapter.PokemonAdapter
import com.upax.androidproject.presentation.adapter.PokemonListener
import com.upax.androidproject.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private var pokemonAdapter: PokemonAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initUI()
        subscribeUI()
        return binding.root
    }

    private fun subscribeUI() {
        viewLifecycleOwner.lifecycleScope.run {
            launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.pokemonList.collect { pokemonList ->
                        pokemonList?.let {
                            pokemonAdapter?.submitList(pokemonList)
                        }
                    }
                }
            }
        }
    }

    private fun initUI() {
        pokemonAdapter = PokemonAdapter(PokemonListener { url ->
            //TODO: Go to detail
        })
        binding.rvPokemon.adapter = pokemonAdapter
        val manager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPokemon.layoutManager = manager
    }

}