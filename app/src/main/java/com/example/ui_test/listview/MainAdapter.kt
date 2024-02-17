package com.example.ui_test.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_test.databinding.TextItemViewBinding

class MainAdapter(val itemClick: (Item) -> Unit) :
    ListAdapter<Item, MainAdapter.TextViewHolder>(callback) {
    companion object {
        val callback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item) =
                oldItem.uuid == newItem.uuid

            override fun areContentsTheSame(oldItem: Item, newItem: Item) =
                oldItem == newItem
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            binding = TextItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val items = getItem(position)
        val infoAdapter = MainInfoAdapter {}
        infoAdapter.submitList(items.body)
        holder.binding.infoRecyclerview.layoutManager = LinearLayoutManager(holder.binding.root.context)
        holder.binding.infoRecyclerview.adapter = infoAdapter
    }

    inner class TextViewHolder(val binding: TextItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}