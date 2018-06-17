package com.github.willgutierrez.example

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.willgutierrez.example.funtionalprograming.Game
import com.github.willgutierrez.example.funtionalprograming.UtilsFunctionalPrograming

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.itemList.observe(this, android.arch.lifecycle.Observer { items ->
            items?.let { showText(it.joinToString { it }) }
        })
        mainViewModel.getFirstStudents()

        printPairVals()

        Game().simulate()

    }

    private fun printPairVals() {
        val (foo, one) = UtilsFunctionalPrograming.someFunction()
        showText(foo)
        showText(one.toString())
    }

    private fun showText(text: String) =
            Log.d("logMain", text)
}
