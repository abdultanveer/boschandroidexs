package com.example.bosch

import androidx.lifecycle.ViewModel

//viewmodel = RAM
class MainViewModel: ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }
}