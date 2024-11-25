package com.example.bosch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bosch.databinding.ActivityInternetBinding
import com.example.bosch.databinding.ActivityMainBinding

class InternetActivity : AppCompatActivity() {
lateinit var binding: ActivityInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnJson.setOnClickListener {
            getJson()
        }

    }

    private fun getJson() {

    }
}