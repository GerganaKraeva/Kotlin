package com.example.myapplication_be.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_be.activity.utility.SharedPrefsHelper
import com.example.myapplication_be.databinding.ActivityCreateNewTaskBinding
import com.google.android.material.snackbar.Snackbar

class CreateNewClassActivity: AppCompatActivity(), SensorEventListener{

    private lateinit var binding: ActivityCreateNewTaskBinding

    private var sensorManager: SensorManager? = null
    private  var sensor:Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityCreateNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager =getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        setDataBinding()
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }

    private fun setDataBinding() {
        binding.btnSaveTask.setOnClickListener {
            val taskName = binding.etTaskName.text.toString()

            if(taskName.isEmpty()){
                Snackbar.make(binding.root, "Task name is empty",Snackbar.LENGTH_LONG).show()

                return@setOnClickListener
            }
            if(SharedPrefsHelper.taskExist(taskName)) {
                Snackbar.make(
                    binding.root,
                    "Task with that name already exist",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            val taskDescription = binding.etTaskDescription.text.toString()
            SharedPrefsHelper.saveTask(taskName, taskDescription)

            finish()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val yReading = event?. values?.get(1) ?: Float.MAX_VALUE
        if (yReading <6.9) {
            binding.etTaskName.setText("")
            binding.etTaskDescription.setText("")
        }

    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


}