package com.ciandt.architecture.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ciandt.architecture.entity.Task

class TasksRepository {

    private val _tasks = mutableListOf(
        Task(1, "Task 1", "Description for Task 1"),
        Task(2, "Task 2", "Description for Task 2"),
        Task(3, "Task 3", "Description for Task 3"),
        Task(4, "Task 4", "Description for Task 4"),
        Task(5, "Task 5", "Description for Task 5"),
        Task(6, "Task 6", "Description for Task 6"),
        Task(7, "Task 7", "Description for Task 7"),
        Task(8, "Task 8", "Description for Task 8"),
        Task(9, "Task 9", "Description for Task 9"),
        Task(10, "Task 10", "Description for Task 10")
    )

    private val tasks = MutableLiveData<List<Task>>().apply { value = _tasks }

    fun tasks(): LiveData<List<Task>> = tasks

    fun addTask(task: Task) {
        val id = _tasks.maxBy { it.id }?.let { it.id + 1 } ?: run { 1 }

        task.id = id
        _tasks.add(task)
//        tasks.value = _tasks
    }
}