package com.example.bosch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bosch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

   /* lateinit var setButton: Button   //declaration
    lateinit var mainTextView: TextView
    lateinit var phoneET:EditText // var numberOfBooks: Int = null
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityMainBinding.inflate(layoutInflater)
       val view = binding.root
       setContentView(view)
       // setContentView(R.layout.activity_main)   //inflation - xml
        /*setButton = findViewById(R.id.btnSet)  //taking handle
        mainTextView = findViewById(R.id.tvMain)
        phoneET = findViewById(R.id.etPhone)*/
        binding.btnSet.setOnClickListener {
            var phnno = binding.etPhone.text.toString()

            binding.tvMain.text = phnno
        }

       binding.btnDial.setOnClickListener {
           var myIntention:Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))
           startActivity(myIntention)
       }



    }

    fun showSnackbar(view: View) {
        var view =  findViewById<ConstraintLayout>(R.id.maincl)
        var snackbar:Snackbar = Snackbar.make(view,"undo delete",Snackbar.LENGTH_LONG)
        snackbar.setAction("undo",{})
        snackbar.show()
        Log.i("MainActivity","showing snnack bar")
       // throw NullPointerException("crash demo")
    }
}