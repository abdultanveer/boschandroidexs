package com.example.bosch.internet

import com.squareup.moshi.Json

//pojo
data class MarsPhoto(
    val  id:String,

    @Json(name = "img_src")
    val  imgSrc:String
)