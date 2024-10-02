package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    private val KEY_SAVE_DATA ="KEY_SAVE_DATA"
    private  val KEY_PREFS_NAME="KEY_PREFS_NAME"


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveData.setOnClickListener{
            val textToSave = binding.etSaveData.text.toString()
            val sharedPrefs = getSharedPreferences(KEY_PREFS_NAME,Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString(KEY_SAVE_DATA,textToSave)
          //editor.apply

            val dataSavedSuccessfully = editor.commit()
            if (dataSavedSuccessfully) {
                Snackbar.make(binding.root, "Data saved successfully", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(binding.root , "Failed to save data", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btnLoadData.setOnClickListener{
            val sharedPrefs = getSharedPreferences(KEY_PREFS_NAME,Context.MODE_PRIVATE)
            val savedText = sharedPrefs.getString(KEY_SAVE_DATA, "No saved data available")
            binding.etLoadData.setText(savedText)
            Snackbar.make(binding.root, "Data loaded", Snackbar.LENGTH_LONG).show()
        }

        binding.btnNextScreen.setOnClickListener {
        val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnClearData.setOnClickListener {
            val sharedPrefs= getSharedPreferences(KEY_PREFS_NAME,Context.MODE_PRIVATE)
            val editor =  sharedPrefs.edit()
            editor.remove(KEY_SAVE_DATA)
            editor.apply()
            Snackbar.make(binding.root, "Data cleared", Snackbar.LENGTH_LONG).show()
        }
    }
}