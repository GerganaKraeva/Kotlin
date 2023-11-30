package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity () {

    private  lateinit var binding: ActivitySecondBinding

    private val KEY_SAVE_DATA ="KEY_SAVE_DATA"
    private  val KEY_PREFS_NAME="KEY_PREFS_NAME"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoadPreviousText.setOnClickListener {
            val sharesPrefs = getSharedPreferences(KEY_PREFS_NAME,Context.MODE_PRIVATE)
            val savedText = sharesPrefs.getString(KEY_SAVE_DATA,"No saved data")
            binding.tvLoadedText.text =savedText
        }
    }
}