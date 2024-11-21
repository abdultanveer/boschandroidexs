package com.example.bosch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bosch.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private lateinit  var binding: ActivityRecyclerBinding
    var languages: Array<String> = arrayOf("english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil",
        "english", "hindi", "urdu", "kannnada", "tamil")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        val view = binding.getRoot()
        setContentView(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = LangAdapter(languages)
        binding.recyclerView.adapter = adapter


    }
}