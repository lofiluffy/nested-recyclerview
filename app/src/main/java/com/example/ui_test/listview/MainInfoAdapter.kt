package com.example.ui_test.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_test.databinding.ItemInfoViewBinding

class MainInfoAdapter(val itemClick: (ItemInfo) -> Unit) :
    ListAdapter<ItemInfo, MainInfoAdapter.TextViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<ItemInfo>() {
            override fun areItemsTheSame(oldItem: ItemInfo, newItem: ItemInfo) =
                oldItem.uuid == newItem.uuid

            override fun areContentsTheSame(oldItem: ItemInfo, newItem: ItemInfo) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            binding = ItemInfoViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            textViewLabel.text = String.format(item.id)
            textViewValue.text = String.format(item.name)
        }
    }

    inner class TextViewHolder(val binding: ItemInfoViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}

