package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoadName.setOnClickListener {
            val textToSave = binding.etEnterName.text.toString()
            val textToShow = "Hello, $textToSave!"
            binding.textGreeting.text = textToShow
            val userName = User (textToShow)
            binding.textGreeting2.text = userName.name
        }

    }
}
data class User (
    var name: String
)