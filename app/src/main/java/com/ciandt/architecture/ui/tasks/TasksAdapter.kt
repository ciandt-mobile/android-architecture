package com.ciandt.architecture.ui.tasks

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ciandt.architecture.R
import com.ciandt.architecture.databinding.RowTaskBinding
import com.ciandt.architecture.entity.Task
import kotlinx.android.synthetic.main.row_task.view.*

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    private lateinit var tasks: List<Task>

    var onClick: ((Task) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(parent.context, parent, onClick = onClick)
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
    ),
    onClick: ((Task) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.taskRow.setOnClickListener {
            binding.task?.let { task ->
                onClick?.let {
                    it(task)
                }
            }
        }
    }

    fun bind(task: Task) {
        binding.task = task
    }
}