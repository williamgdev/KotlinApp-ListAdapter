package com.github.willgutierrez.example

import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.willgutierrez.example.funtionalprograming.Game
import com.github.willgutierrez.example.funtionalprograming.UtilsFunctionalPrograming
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user_layout.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val adapter = listAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.itemList.observe(this, { items ->
            items?.let { result ->
                showText(result.joinToString { it })
                adapter.submitList(result.toItemList())
            }
        })
        mainViewModel.getFirstStudents()

        printPairVals()

        Game().simulate()

    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter
    }

    private fun printPairVals() {
        val (foo, one) = UtilsFunctionalPrograming.someFunction()
        showText(foo)
        showText(one.toString())
    }

    private fun showText(text: String) =
            Log.d("logMain", text)
}

private fun List<String>.toItemList(): List<Item> =
        map {
            UserItem(it)
        }

class UserItem(override val content: String) : Item {
    override val layoutResource: Int = R.layout.item_user_layout
    override val id = javaClass

    override fun AdapterLayout.bind() {
        userName.text = content
    }

}
