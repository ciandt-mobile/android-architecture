package com.ciandt.architecture.ui.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ciandt.architecture.entity.Task
import com.ciandt.architecture.repository.TasksRepository
import com.ciandt.architecture.ui.Event

class TasksViewModel : ViewModel() {

    private val repository = TasksRepository()
    private val _detail = MutableLiveData<Event<Boolean>>()
    private val _back = MutableLiveData<Event<Boolean>>()
    private var task: Task? = null

    val tasks: LiveData<List<Task>> = repository.tasks()
    val detail: LiveData<Event<Boolean>>
        get() = _detail
    val back: LiveData<Event<Boolean>>
        get() = _back
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun addTask() {
        task = Task(-1, "", "")
        title.value = task?.title
        description.value = task?.description
        _detail.value = Event(true)
    }

    fun updateTask(task: Task) {
        this.task = task
        title.value = task.title
        description.value = task.description
        _detail.value = Event(true)
    }

    fun saveTask() {
        task?.let {
            title.value?.apply { it.title = this }
            description.value?.apply { it.description = this }

            if (it.id == -1) {
                repository.addTask(it)
            }

            task = null
            _back.value = Event(true)
        }
    }
}