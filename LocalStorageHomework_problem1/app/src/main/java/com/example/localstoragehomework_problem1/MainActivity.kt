package com.example.localstoragehomework_problem1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localstoragehomework_problem1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val KEY_SAVE_DATA = "KEY_SAVE_DATA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSaveText.setOnClickListener {
            val textToSave =  binding.etEnterText.text.toString()
            val sharedPrefs = getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString(KEY_SAVE_DATA,textToSave)
            editor.apply()

        }

        binding.btnLoadText.setOnClickListener {
            val sharedPrefs=getPreferences(Context.MODE_PRIVATE)
            val savedText = sharedPrefs.getString(KEY_SAVE_DATA,"No saved text")
            binding.tvLoadText.text = savedText
        }
    }
}