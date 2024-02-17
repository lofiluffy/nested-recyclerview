package com.example.ui_test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.ui_test.databinding.ActivityMainBinding
import com.example.ui_test.listview.Item
import com.example.ui_test.listview.ItemInfo
import com.example.ui_test.listview.MainController


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val items: ArrayList<Item> = arrayListOf()
    private val controller: MainController by lazy {
        MainController()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        List(100) {
            val info = arrayListOf<ItemInfo>()
            List(10) { infoItem ->
                info.add(
                    ItemInfo(
                        id = "item_info_$infoItem",
                        name = "item_info_$infoItem"
                    )
                )

            }
            items.add(
                Item(
                    id = it,
                    name = "Item $it",
                    body = info
                )
            )
        }
        val layoutManager: LayoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.setController(controller)
        controller.submitList(items)
        ViewCompat.setNestedScrollingEnabled(binding.recyclerview, false)
    }
}