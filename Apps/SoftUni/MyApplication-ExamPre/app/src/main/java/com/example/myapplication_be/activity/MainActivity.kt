package com.example.myapplication_be.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication_be.activity.utility.Constants
import com.example.myapplication_be.activity.utility.SharedPrefsHelper
import com.example.myapplication_be.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPrefsHelper.init(this)
        setDataBinding()
        showSavedTasks()

    }


    private fun setDataBinding() {
        binding.btnCreateNewTask.setOnClickListener{
            val intent = Intent (this, CreateNewClassActivity::class.java)
            startActivity(intent)
        }
        binding.btnConfirm.setOnClickListener {
            val taskIndex = binding.etUserChoice.text.toString().toInt() - 1
            val task = SharedPrefsHelper.getTaskWithIndex(taskIndex)
            val intent = Intent(this, ReviewTaskActivity :: class.java)
            intent.putExtra(Constants.KEY_REVIEW_TASK_NAME, task.first)
            intent.putExtra(Constants.KEY_REVIEW_TASK_DESCRIPTION,task.second as String)
            startActivity(intent)
        }
    }

    private fun showSavedTasks() {
        binding.layoutTasks.removeAllViews()
        val tasks=SharedPrefsHelper.getAllTasks()

        if(tasks.isEmpty()) {
//            binding.tvTasks.text="No saved tasks available"
            val button = MaterialButton(this)
            button.text = "No save data available"
            binding.layoutTasks.addView(button)
        }
        tasks.mapIndexed { index, task -> "${index + 1}. $task"  }
            .forEach{
                val button =MaterialButton(this)
                button.text=it
                button.setOnClickListener{view->
                    val animation = view.animate().rotationX(360f).setDuration(1000)
                    animation.withEndAction {
                        val intent = Intent(this, ReviewTaskActivity:: class.java)
                        val taskDescription = SharedPrefsHelper.getTaskDescription(it)
                        intent.putExtra(Constants.KEY_REVIEW_TASK_NAME,it )
                        intent.putExtra(Constants.KEY_REVIEW_TASK_DESCRIPTION, taskDescription)
                        startActivity(intent)
                    }
                }
                binding.layoutTasks.addView(button)
            }
//        binding.tvTasks.text=tasks.mapIndexed { index, task ->
//            "${index + 1}. $task" }
//            .joinToString("\n")

    }

    override fun onResume() {
        super.onResume()
        showSavedTasks()
    }


}