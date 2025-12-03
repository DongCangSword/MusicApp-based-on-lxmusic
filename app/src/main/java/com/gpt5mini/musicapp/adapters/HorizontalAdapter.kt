package com.gpt5mini.musicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gpt5mini.musicapp.databinding.ItemHorizontalCardBinding

class HorizontalAdapter(private val items: List<String>) : RecyclerView.Adapter<HorizontalAdapter.VH>() {
    inner class VH(val binding: ItemHorizontalCardBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemHorizontalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.title.text = items[position]
    }
    override fun getItemCount() = items.size
}
