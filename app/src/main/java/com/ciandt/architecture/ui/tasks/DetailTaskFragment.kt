package com.ciandt.architecture.ui.tasks

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.architecture.R
import com.ciandt.architecture.databinding.FragmentDetailTaskBinding
import com.ciandt.architecture.ui.MainActivity
import com.ciandt.architecture.ui.subscribe
import kotlinx.android.synthetic.main.fragment_detail_task.*

class DetailTaskFragment : Fragment() {

    private lateinit var viewModel: TasksViewModel
    private lateinit var binding: FragmentDetailTaskBinding

    val titleWatcher = BindingEditText {
        binding.viewModel?.let { viewModel ->
            if (viewModel.title.value != it) {
                viewModel.title.value = it
            }
        }
    }

    val descriptionWatcher = BindingEditText {
        binding.viewModel?.let { viewModel ->
            if (viewModel.description.value != it) {
                viewModel.description.value = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_task, container, false)

        binding.setLifecycleOwner(this)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val main = activity as MainActivity

        viewModel = ViewModelProviders.of(main)[TasksViewModel::class.java]

        binding.viewModel = viewModel
        binding.fragment = this

        saveButton.setOnClickListener { viewModel.saveTask() }

        viewModel.back.subscribe(main) { main.goBack() }
    }
}

class BindingEditText(private val binding: (String) -> Unit) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding(s.toString())
    }
}