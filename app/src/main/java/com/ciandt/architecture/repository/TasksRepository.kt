package com.ciandt.architecture.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ciandt.architecture.entity.Task

class TasksRepository {

    fun tasks(): LiveData<List<Task>> {
        return MutableLiveData<List<Task>>().apply {
            value = listOf(
                Task("Task 1", "Description for Task 1"),
                Task("Task 2", "Description for Task 2"),
                Task("Task 3", "Description for Task 3"),
                Task("Task 4", "Description for Task 4"),
                Task("Task 5", "Description for Task 5"),
                Task("Task 6", "Description for Task 6"),
                Task("Task 7", "Description for Task 7"),
                Task("Task 8", "Description for Task 8"),
                Task("Task 9", "Description for Task 9"),
                Task("Task 10", "Description for Task 10")
            )
        }
    }
}