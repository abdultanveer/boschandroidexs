package com.example.bosch

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//viewmodel = RAM
class MainViewModel: ViewModel() {
    var TAG = MainViewModel::class.java.simpleName
    var count = 0
    lateinit var timer: CountDownTimer
    //convert it innto observable
    var _seconds = MutableLiveData<Int>()
    //_ meanns mutable


    fun incrementCount(){
        count++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemainning: Long) {
                _seconds.value = timeRemainning.toInt()
                Log.i(TAG,"seconds value ="+_seconds)
            }

            override fun onFinish() {
               // _seconds.value = "finished"
                Log.i(TAG,"timer finnished")
            }

        }.start()
    }
}