package com.example.bosch

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bosch.databinding.ActivityInternetBinding
import com.example.bosch.databinding.ActivityMainBinding
import com.example.bosch.internet.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InternetActivity : AppCompatActivity() {
    var TAG = InternetActivity::class.java.simpleName
lateinit var binding: ActivityInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnJson.setOnClickListener {
            getMarsPhotos()
        }

    }

    private fun getMarsPhotos() {
        GlobalScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            Log.i(TAG,listResult.toString())
        }

    }

}