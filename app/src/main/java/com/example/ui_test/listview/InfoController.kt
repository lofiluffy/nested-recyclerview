package com.example.ui_test.listview

import com.airbnb.epoxy.EpoxyController
import com.example.ui_test.listview.epoxymodel.complexItem
import com.example.ui_test.listview.epoxymodel.infoItem
import java.util.concurrent.CopyOnWriteArrayList

class InfoController: EpoxyController() {

    private val items: CopyOnWriteArrayList<ItemInfo> = CopyOnWriteArrayList()

    fun submitList(items: ArrayList<ItemInfo>) {
        this.items.clear()
        this.items.addAll(items)
        requestModelBuild()
    }

    override fun buildModels() {
        if(items.isNotEmpty()) {
            items.forEach {
                infoItem {
                    id("info_${it.uuid}")
                    itemInfo(it)
                }
            }
        }
    }
}