package com.upax.androidproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.upax.androidproject.core.domain.entity.model.Pokemon
import com.upax.androidproject.databinding.ItemPokemonBinding

class PokemonAdapter(private val clickListener: PokemonListener) :
    ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(
        PokemonDiffCallback()
    ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pokemon, clickListener: PokemonListener) {
            binding.pokemon = item
            binding.onclickListener = clickListener
            binding.executePendingBindings()
            binding.tvName.text = item.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPokemonBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name
    }


    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }


}

class PokemonListener(val clickListener: (pokemonUrl: String) -> Unit) {
    fun onClick(pokemon: Pokemon) = clickListener(pokemon.url)

}