package com.example.ui_test.listview

import java.util.UUID

data class Item(
    val uuid: UUID = UUID.randomUUID(),
    val id: Int,
    val name: String,
    val body: ArrayList<ItemInfo>
)

data class ItemInfo(
    val uuid: UUID = UUID.randomUUID(),
    val id: String,
    val name: String,
)