package com.trisulaforce.laundryapp.model

import java.io.Serializable

data class Notifikasi (
    val id: Long,
    val image: Int = 0,
    val title: String,
    val text: String,
    val tanggal: String
) : Serializable