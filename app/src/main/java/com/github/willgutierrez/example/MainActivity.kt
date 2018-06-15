package com.github.willgutierrez.example

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.itemList.observe(this, android.arch.lifecycle.Observer { items ->
            items?.let { Log.d("logMain", it.joinToString { it }) }
        })
        mainViewModel.getFirstStudents()
    }
}
