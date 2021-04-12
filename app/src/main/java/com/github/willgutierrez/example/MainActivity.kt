package com.github.willgutierrez.example

import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.itemList.observe(this, androidx.lifecycle.Observer { items ->
            items?.let { showText(it.joinToString { it }) }
        })
        mainViewModel.getFirstStudents()

        printPairVals()
    }

    private fun printPairVals() {
        val (foo, one) = UtilsFunctionalPrograming.someFunction()
        showText(foo)
        showText(one.toString())
    }

    private fun showText(text: String) =
            Log.d("logMain", text)
}
