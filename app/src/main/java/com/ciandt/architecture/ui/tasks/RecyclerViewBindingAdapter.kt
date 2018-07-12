@file:JvmName("RecyclerViewBindingAdapter")

package com.ciandt.architecture.ui.tasks

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.ciandt.architecture.entity.Task

@BindingAdapter("tasks")
fun RecyclerView.bindTasks(tasks: List<Task>) {
    val adapter = adapter as TasksAdapter
    adapter.update(tasks)
}