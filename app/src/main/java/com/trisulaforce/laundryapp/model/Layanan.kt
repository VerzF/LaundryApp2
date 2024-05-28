package com.trisulaforce.laundryapp.model

import java.io.Serializable

data class Layanan (
    val id: Long,
    val image: Int = 0,
    val title: String,
    val price: Int
) : Serializable