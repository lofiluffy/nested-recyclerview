package com.example.ui_test.listview.epoxymodel

import android.view.View
import android.view.ViewParent
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.ui_test.R
import com.example.ui_test.databinding.ItemInfoViewBinding
import com.example.ui_test.databinding.TextItemViewBinding
import com.example.ui_test.listview.ItemInfo

@EpoxyModelClass
abstract class InfoItemModel : EpoxyModelWithHolder<InfoItemModel.InfoItemViewHolder>() {

    @EpoxyAttribute
    var itemInfo: ItemInfo? = null

    override fun getDefaultLayout(): Int = R.layout.item_info_view

    override fun bind(holder: InfoItemViewHolder) {
        super.bind(holder)
        holder.binding.textViewLabel.text = itemInfo?.id.toString()
        holder.binding.textViewValue.text = itemInfo?.name.toString()
    }

    class InfoItemViewHolder : EpoxyHolder() {

        lateinit var binding: ItemInfoViewBinding
            private set

        override fun bindView(itemView: View) {
            binding = ItemInfoViewBinding.bind(itemView)
        }
    }
}