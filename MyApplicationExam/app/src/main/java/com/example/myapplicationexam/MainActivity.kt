package com.example.myapplicationexam

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationexam.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() , SensorEventListener {

    private lateinit var binding: ActivityMainBinding
    private val KEY_SAVE_DATA = "KEY_SAVE_DATA"
    private var sensorManager: SensorManager? = null
    private  var sensor: Sensor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager =getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        setBindingData()

    }

    override fun onResume() {
        super.onResume()
        showSavedNote()

        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    private fun showSavedNote() {
       val savedNote= binding.tvLastSavedTask.text
        if(savedNote!="" && savedNote!=null ) {
            binding.btnShowSavedNote.isEnabled=true;
            binding.tvLastSavedTask.text=savedNote
        }
    }


    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)

    }

    private fun setBindingData() {
        binding.btnSaveNote.setOnClickListener {
            val noteToSave = binding.etNote.text.toString()
            val sharedPrefs = getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString(KEY_SAVE_DATA, noteToSave)

            val dataSavedSuccessfully = editor.commit()
            if (dataSavedSuccessfully) {
                Snackbar.make(binding.root, "Note saved successfully", Snackbar.LENGTH_LONG).show()
                binding.btnShowSavedNote.isEnabled=true
            } else {
                Snackbar.make(binding.root, "No note to save", Snackbar.LENGTH_LONG).show()
                binding.btnShowSavedNote.isEnabled=false

            }

        }

        binding.btnShowSavedNote.setOnClickListener {
            val noteToSave = binding.etNote.text.toString()
            val lastNote = LastNote(noteToSave)
            binding.tvLastSavedTask.text = lastNote.name
        }

    }

    override fun onSensorChanged(event: SensorEvent?) {
        val yReading = event?. values?.get(1) ?: Float.MAX_VALUE
        if (yReading <6.9) {
            binding.etNote.setText("")
            binding.tvLastSavedTask.text=""
            binding.btnShowSavedNote.isEnabled=false
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}

data class LastNote(
    var name: String
)
