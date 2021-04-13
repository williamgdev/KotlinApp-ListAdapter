package com.github.willgutierrez.example.funtionalprograming

import com.github.willgutierrez.example.Students

object UtilsFunctionalPrograming {
    fun filterList(students: MutableList<Students>, ageFilter: Int, size: Int): List<Students> {
        return students.filter { it.age == ageFilter && !it.passing }
                .take(size)
                .sortedWith(compareBy({ it.age }, { it.name }))
    }

    fun listToString(filterList: List<Students>) =
        filterList.map { student -> "${student.name}  -  ${student.age}" }

    fun someFunction(): Pair<String, Int> = Pair("foo", 1)
    fun someFunction1(): Pair<String, Int> = "foo" to 1
    fun someFunction2(): Map<String, Int> = mapOf("foo" to 1, "foo2" to 2)
    fun someFunction3(): Triple<String, Int, Int> = Triple("foo", 1, 1)
}