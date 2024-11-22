package com.example.bosch.database

//pojo/VO/model


data class Item(
    val id: Int = 0,
    val itemName: String,
    val itemPrice: Double,
    val quantityInStock: Int
    )