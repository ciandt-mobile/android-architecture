package com.ciandt.architecture.ui.tasks

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.architecture.R
import com.ciandt.architecture.databinding.FragmentTasksBinding
import com.ciandt.architecture.ui.MainActivity
import com.ciandt.architecture.ui.subscribe
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksFragment : Fragment() {

    private lateinit var viewModel: TasksViewModel
    private lateinit var binding: FragmentTasksBinding
    private lateinit var main: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tasks, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        main = activity as MainActivity

        viewModel = ViewModelProviders.of(main)[TasksViewModel::class.java]

        setupRecycler()

        binding.viewModel = viewModel

        viewModel.detail.subscribe(main) { main.gotoDetailTask() }

        addButton.setOnClickListener { viewModel.addTask() }
    }

    private fun setupRecycler() {
        recyclerTasks.layoutManager = LinearLayoutManager(context)
        recyclerTasks.hasFixedSize()

        val taskAdapter = TasksAdapter()

        taskAdapter.onClick = { viewModel.updateTask(it) }

        recyclerTasks.adapter = taskAdapter
    }
}
