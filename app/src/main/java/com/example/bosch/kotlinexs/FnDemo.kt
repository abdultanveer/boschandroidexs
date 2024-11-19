package com.example.bosch.kotlinexs
val upperCase1: (String) -> String = { str: String -> str.uppercase() } // 1

fun main() {
    var a :Int = 20
    val enc1: (String) -> String = { input -> input.toUpperCase() }
   println( encodeMsg("abdul",enc1))

    println(encodeMsg("RACE-CAR",::enc2))
    var wl:String = "abdul"
    println(upperCase1("hello"))
    add(c=60, a= 10)
    add(10,c=30)
    drive("turtle-like")
    println("hello world")
    printHello("abdul")   //abdul = argument
}

fun enc2(input:String): String = input.reversed()


fun convertToUpperCase(name: String):String{
    return  name.uppercase()
}


fun printHello(name: String?) {    //name = param
    println("Hi there!"+name)
}

fun add(a:Int, b:Int = 20, c:Int){

}

fun drive(speed: String = "fast") {
    println("driving $speed")
}

fun encodeMsg(msg: String,
              encode: (String) -> String): String {

    return encode(msg)
}


