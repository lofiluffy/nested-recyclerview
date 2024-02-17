package com.example.ui_test.listview

import com.airbnb.epoxy.EpoxyController
import com.example.ui_test.listview.epoxymodel.complexItem
import com.example.ui_test.listview.epoxymodel.infoItem
import java.util.concurrent.CopyOnWriteArrayList

class MainController: EpoxyController() {

    private val items: CopyOnWriteArrayList<Item> = CopyOnWriteArrayList()

    fun submitList(items: ArrayList<Item>) {
        this.items.clear()
        this.items.addAll(items)
        requestModelBuild()
    }

    override fun buildModels() {
        if(items.isNotEmpty()) {
            items.forEach { item ->
                complexItem {
                    id("complex_item_${item.uuid}")
                    item(item)
                }
            }
        }
    }

}