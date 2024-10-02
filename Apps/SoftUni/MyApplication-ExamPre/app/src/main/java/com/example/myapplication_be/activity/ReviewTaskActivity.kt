package com.example.myapplication_be.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_be.activity.utility.Constants
import com.example.myapplication_be.activity.utility.SharedPrefsHelper
import com.example.myapplication_be.databinding.ActivityReviewTaskBinding
import com.google.android.material.snackbar.Snackbar

class ReviewTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReviewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDataBinding()
    }

    private fun setDataBinding() {
        val taskName = intent.getStringExtra(Constants.KEY_REVIEW_TASK_NAME)
        val taskDescription = intent.getStringExtra(Constants.KEY_REVIEW_TASK_DESCRIPTION)
        binding.taskName = taskName
        binding.taskDescription =taskDescription

        binding.btnCompleteTask.setOnClickListener {
            if (taskName == null) {
                Snackbar.make(binding.root, "Something went wrong",Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            SharedPrefsHelper.completeTask(taskName)
            finish()
        }



    }

}