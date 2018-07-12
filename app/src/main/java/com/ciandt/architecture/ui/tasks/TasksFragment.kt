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
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksFragment : Fragment() {

    private lateinit var viewModel: TasksViewModel
    private lateinit var binding: FragmentTasksBinding

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

        viewModel = ViewModelProviders.of(this)[TasksViewModel::class.java]

        recyclerTasks.layoutManager = LinearLayoutManager(context)
        recyclerTasks.hasFixedSize()
        recyclerTasks.adapter = TasksAdapter()

        binding.viewModel = viewModel
    }
}
