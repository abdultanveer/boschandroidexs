package com.example.bosch

import android.content.ComponentName
import android.content.ContentValues
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
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
import com.example.bosch.databinding.ActivityMainBinding
import com.example.bosch2.IAddition
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var iRemoteService: IAddition? = null

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
       // setContentView(R.layout.activity_main)   //inflation - xml
        /*setButton = findViewById(R.id.btnSet)  //taking handle
        mainTextView = findViewById(R.id.tvMain)
        phoneET = findViewById(R.id.etPhone)*/
        binding.btnSet.setOnClickListener {
            var phnno = binding.etPhone.text.toString()

            binding.tvMain.text = phnno
        }

       binding.btnDial.setOnClickListener {
          // startDialer()
           startHomeActivity()
       }

       binding.btnAlarm.setOnClickListener {
          // createAlarm("bosch",10,42)
           var msg = binding.etPhone.text.toString()
           binding.tvMain.text = msg
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


    override fun onStart() {
        super.onStart()
        Log.e(TAG,"im in onStart--getting data/location")
        binding.btnputcp.setOnClickListener {
            var uri = Uri.parse("content://com.example.appa.provider/contacts")
            var cursor = contentResolver.query(uri,null,null,null,null)
            var values = ContentValues()
            values.put("name","bosch-anndroid")
            values.put("phone",9876543)
            contentResolver.insert(uri,values)
        }

        binding.btngetcp.setOnClickListener {
            var uri = Uri.parse("content://com.example.appa.provider/contacts")
            var cursor = contentResolver.query(uri,null,null,null,null)
            cursor?.moveToLast()
            var name = cursor?.getColumnIndex("name")?.let { cursor.getString(it) }
            var phone = cursor?.getColumnIndex("phone")?.let { cursor.getString(it) }
            binding.tvMain.setText("name--"+ name+"-phone no is--"+phone)
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"im in onResume--restore state")
        binding.btnBind.setOnClickListener { bindAdditionService() }

    }

    private fun bindAdditionService() {
        var addInmntent = Intent("hey.please.add.nos")


        val pack = IAddition::class.java.`package`
        addInmntent.setPackage(pack.name)
        bindService(addInmntent,serviceConnection, BIND_AUTO_CREATE)
    }

    private val serviceConnection = object : ServiceConnection {

        override fun onServiceConnected(p0: ComponentName?, aidlBinder: IBinder?) {//3

            iRemoteService = IAddition.Stub.asInterface(aidlBinder)
             var result =   iRemoteService?.sumAdd(30,40)
            binding.tvMain.text = "result sum --"+result

//            val mylocalBinder = localBinder as AdditionService.LocalBinder
//            additionService = mylocalBinder.getService()//4
//            var sum = additionService.addNos(10,20)//6
//            binding.textView.text ="sum--"+sum //8
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
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