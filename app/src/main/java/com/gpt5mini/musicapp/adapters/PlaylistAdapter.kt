package com.gpt5mini.musicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gpt5mini.musicapp.databinding.ItemPlaylistRowBinding

class PlaylistAdapter(private val items: List<String>) : RecyclerView.Adapter<PlaylistAdapter.VH>() {
    inner class VH(val binding: ItemPlaylistRowBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemPlaylistRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.title.text = items[position]
    }
    override fun getItemCount() = items.size
}
