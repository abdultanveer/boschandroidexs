package com.example.bosch

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.bosch.databinding.ActivityInternetBinding
import com.example.bosch.internet.MarsApi
import com.example.bosch.internet.MarsPhoto
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InternetActivity : AppCompatActivity() {
    var TAG = InternetActivity::class.java.simpleName
    lateinit var adapter:WordListAdapter
    lateinit var listPhotos:List<MarsPhoto>

lateinit var binding: ActivityInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       getMarsPhotos()
         adapter = WordListAdapter()
        binding.recyclerView.layoutManager =  LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnJson.setOnClickListener {
            getMarsPhotos()
        }

    }

    private fun getMarsPhotos() {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }
        GlobalScope.launch(Dispatchers.Main
                + coroutineExceptionHandler) {
            listPhotos = MarsApi.retrofitService.getPhotos()
            adapter.submitList(listPhotos)
            adapter.notifyDataSetChanged()
            val url = listPhotos.get(0).imgSrc
           binding.tvJson.setText(url)
            Log.i(TAG,url.toString())
            //binding.imageView.load(url)
        }

    }

}