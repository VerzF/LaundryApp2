package com.trisulaforce.laundryapp.model

import java.io.Serializable

data class Pesanan(
    val idPesanan: String,
    val date: String,
    val customerName: String,
    val services: List<Layanan>,
    val duration: String,
    val totalPrice: Int,
    val perfume: String,
    val paymentMethod: String,
    val status: String,
    val notes: String
) : Serializable
