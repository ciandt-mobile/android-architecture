package com.ciandt.architecture.ui.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ciandt.architecture.entity.Task
import com.ciandt.architecture.repository.TasksRepository

class TasksViewModel : ViewModel() {

    private val repository = TasksRepository()

    val tasks: LiveData<List<Task>> = repository.tasks()
}