package com.ciandt.architecture.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ciandt.architecture.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        gotoTasks()
    }

    private fun gotoTasks() {
        val tasksFragment = TasksFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mainContent, tasksFragment)
        transaction.commit()
    }
}
