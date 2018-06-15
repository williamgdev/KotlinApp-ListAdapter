package com.github.willgutierrez.example

object UtilsFuntionalPrograming {
    fun filterList(students: MutableList<Students>, ageFilter: Int, size: Int): List<Students> {
        return students.filter { it.age == ageFilter && !it.passing }
                .take(size)
                .sortedWith(compareBy({ it.age }, { it.name }))
    }

    fun listToString(filterList: List<Students>) =
        filterList.map { student -> "${student.name}  -  ${student.age}" }
}