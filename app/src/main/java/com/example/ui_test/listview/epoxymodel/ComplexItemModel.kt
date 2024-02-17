package com.example.ui_test.listview.epoxymodel

import android.view.View
import android.view.ViewParent
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.ui_test.R
import com.example.ui_test.databinding.TextItemViewBinding
import com.example.ui_test.listview.InfoController
import com.example.ui_test.listview.Item
import com.example.ui_test.listview.ItemInfo

@EpoxyModelClass
abstract class ComplexItemModel : EpoxyModelWithHolder<ComplexItemModel.ComplexItemViewHolder>() {

    private val controller = InfoController()

    @EpoxyAttribute
    var item: Item? = null

    override fun getDefaultLayout(): Int = R.layout.text_item_view

    override fun bind(holder: ComplexItemViewHolder) {
        super.bind(holder)

        val layoutManager = LinearLayoutManager(holder.binding.root.context)
        holder.binding.infoRecyclerview.layoutManager = layoutManager
        holder.binding.infoRecyclerview.setController(controller)
        holder.binding.infoRecyclerview.setHasFixedSize(true)
        holder.binding.infoRecyclerview.setItemViewCacheSize(item?.body?.size ?: 0)
        controller.submitList(item?.body ?: arrayListOf())
    }

    class ComplexItemViewHolder : EpoxyHolder() {

        lateinit var binding: TextItemViewBinding
            private set

        override fun bindView(itemView: View) {
            binding = TextItemViewBinding.bind(itemView)
        }
    }
}