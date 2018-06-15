package com.github.willgutierrez.example

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var itemList = MutableLiveData<List<String>>()

    fun getFirstStudents () {

        val students = mutableListOf<Students>().apply {
            add(Students("Student 1", 4, true))
            add(Students("Student 2", 4))
            add(Students("Student 3", 4))
            add(Students("Student 4", 4))
            add(Students("Student 5", 7, true))
        }

        val filterList = UtilsFunctionalPrograming.filterList(students, 4, 3)

        itemList.value = UtilsFunctionalPrograming.listToString(filterList)
    }


}
