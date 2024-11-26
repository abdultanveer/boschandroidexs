package com.example.bosch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bosch.databinding.ActivityInternetBinding
import com.example.bosch.internet.MarsApi
import com.example.bosch.internet.MarsPhoto
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class InternetActivity : AppCompatActivity() {
    var TAG = InternetActivity::class.java.simpleName
    lateinit var adapter:WordListAdapter
    lateinit var listPhotos:List<MarsPhoto>
    val db = Firebase.firestore

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


    override fun onStart() {
        super.onStart()
        binding.btnSend.setOnClickListener { sendFirestore() }
        binding.btnGet.setOnClickListener { getFireStore() }
        binding.btnFcm.setOnClickListener { getFcmToken() }
    }

    private fun getFcmToken() {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task: Task<String> ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@addOnCompleteListener
                }
                // Get the FCM token
                val token = task.result
                Log.d(TAG, "FCM Registration Token: $token")
            }    }


    private fun getFireStore() {
        db.collection("bosch")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    private fun sendFirestore() {
// Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "vignesh",
            "last" to "mudassir",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("bosch")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
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
           //binding.tvJson.setText(url)
            Log.i(TAG,url.toString())
            //binding.imageView.load(url)
        }

    }

}