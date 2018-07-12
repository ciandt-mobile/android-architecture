package com.ciandt.architecture.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ciandt.architecture.R
import com.ciandt.architecture.ui.tasks.DetailTaskFragment
import com.ciandt.architecture.ui.tasks.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        gotoTasks()
    }

    fun gotoTasks() {
        val tasksFragment = TasksFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mainContent, tasksFragment)
        transaction.commit()
    }

    fun gotoDetailTask() {
        val detailFragment = DetailTaskFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContent, detailFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun goBack() {
        supportFragmentManager.popBackStack()
    }
}
