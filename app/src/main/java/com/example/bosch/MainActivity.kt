package com.example.bosch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bosch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel

    var TAG = MainActivity::class.java.simpleName
    //"MainActivity"
   /* lateinit var setButton: Button   //declaration
    lateinit var mainTextView: TextView
    lateinit var phoneET:EditText // var numberOfBooks: Int = null
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"im in oncreate")
       binding = ActivityMainBinding.inflate(layoutInflater)
       val view = binding.root

       setContentView(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // setContentView(R.layout.activity_main)   //inflation - xml
        /*setButton = findViewById(R.id.btnSet)  //taking handle
        mainTextView = findViewById(R.id.tvMain)
        phoneET = findViewById(R.id.etPhone)*/
        binding.btnSet.setOnClickListener {
            var phnno = binding.etPhone.text.toString()

            binding.tvMain.text = phnno
        }
        binding.tvMain.setText(""+viewModel.count)

       binding.btnDial.setOnClickListener {
          // startDialer()
           startHomeActivity()
       }

       binding.btnAlarm.setOnClickListener {
           createAlarm("bosch",10,42)
       }



    }

    private fun startHomeActivity() {
        var c = 10+ 20;
        add(40,50)
        var homeIntent = Intent(this,HomeActivity::class.java)
        homeIntent.putExtra("mykey","bosch-anndroid")
        startActivityForResult(homeIntent,123) //1
    }

    fun add(a:Int,b:Int): Int {
        var d = a + 40;
        var c = d+b+a-10
        repeat(9){
            d++
            var f = d+ c *20
        }

        return a+b
    }

    private fun startDialer() {
        var myIntention: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))
        startActivity(myIntention)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, dataIntennt: Intent?) {
        super.onActivityResult(requestCode, resultCode, dataIntennt)
        var contact = dataIntennt?.extras?.getString("conkey")//3
        binding.tvMain.setText(contact)
    }


    var secsObserverphno: Observer<Int> = object : Observer<Int> {
        override fun onChanged(seconds: Int) {
            //receiving the update/notification
            binding.tvMain.setText(seconds.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"im in onStart--getting data/location")

        //subscribe to seconds or observe seconds
        viewModel._seconds.observe(this, secsObserverphno); //me giving my phno to the postman

        binding.btnInc.setOnClickListener {
            //viewModel.incrementCount()
            viewModel.startTimer()
            binding.tvMain.setText("seconds left --"+viewModel._seconds)

        }

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"im in onResume--restore state")

    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG,"im in onPause--save state")

    }

    override fun onStop() {
        super.onStop()
        Log.w(TAG,"im in onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"im in onDestroy--release the resources")

    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
       // if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        //}
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