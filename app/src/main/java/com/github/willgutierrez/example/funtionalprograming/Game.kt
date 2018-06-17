package com.github.willgutierrez.example.funtionalprograming

import android.util.Log

class Game {
    fun simulate() {

        north()
        south()
        west()
        north()
        east()
        end()
    }

    private var path = mutableListOf<Direction>()

    init {
        path.add(Direction.START)
    }

    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = {
        path.add(Direction.END)
        Log.d("game", "Game Over $path")
        path.clear()
        Log.d("game", "again= $path")
         false
    }

}

enum class Direction {
    NORTH, SOUTH, WEST, EAST,
    START, END
}