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
import com.example.bosch.database.Item
import com.example.bosch.database.ItemDao
import com.example.bosch.database.ItemRoomDatabase
import com.example.bosch.database.Student
import com.example.bosch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel
    lateinit var dao: ItemDao

    var TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"im in oncreate")
       binding = ActivityMainBinding.inflate(layoutInflater)
       val view = binding.root

       setContentView(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

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
            var abdul = Student("abdul",123,true,567)
           // abdul.name = "ansari"
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"im in onStart--getting data/location")

        binding.btnInsert.setOnClickListener {
            insertDataDb()
        }
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

    private fun insertDataDb() {

        GlobalScope.launch {
            var groceryItem:Item = Item(11,"fruits",11.11,22)
            dao.insert(groceryItem)
        }
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