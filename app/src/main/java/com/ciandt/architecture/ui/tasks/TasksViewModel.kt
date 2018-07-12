package com.ciandt.architecture.ui.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ciandt.architecture.entity.Task
import com.ciandt.architecture.repository.TasksRepository
import com.ciandt.architecture.ui.SimpleEvent

class TasksViewModel : ViewModel() {

    private val repository = TasksRepository()
    private val _detail = MutableLiveData<SimpleEvent>()
    private val _back = MutableLiveData<SimpleEvent>()
    private var task: Task? = null

    val tasks: LiveData<List<Task>> = repository.tasks()

    val detail: LiveData<SimpleEvent>
        get() = _detail

    val back: LiveData<SimpleEvent>
        get() = _back

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun addTask() {
        task = Task(-1, "", "")
        title.value = task?.title
        description.value = task?.description
        _detail.value = SimpleEvent()
    }

    fun updateTask(task: Task) {
        this.task = task
        title.value = task.title
        description.value = task.description
        _detail.value = SimpleEvent()
    }

    fun saveTask() {
        task?.let {
            title.value?.apply { it.title = this }
            description.value?.apply { it.description = this }

            if (it.id == -1) {
                repository.addTask(it)
            }

            task = null
            _back.value = SimpleEvent()
        }
    }
}