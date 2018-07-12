package com.ciandt.architecture.ui.tasks

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ciandt.architecture.R
import com.ciandt.architecture.databinding.RowTaskBinding
import com.ciandt.architecture.entity.Task

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    private lateinit var tasks: List<Task>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(parent.context, parent)
    }

    override fun getItemCount() = if (::tasks.isInitialized) tasks.size else 0

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    fun update(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }
}

class TaskViewHolder(
    context: Context,
    parent: ViewGroup,
    private val binding: RowTaskBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.row_task,
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: Task) {
        binding.task = task
    }
}